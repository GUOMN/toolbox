#!/bin/bash
DISK_USEAGE=0
LIMIT_PERCENT=8
REQUEST_BODY='{ "msgtype": "text", "text": {"content": "4041磁盘占用超过80%, 以下服务请尽快清理工作目录: \nLIST","mentioned_mobile_list":["@all"]}}'
CONTENT=""
# 计算磁盘占用情况
function cal() {
  DISK_USEAGE=$(df -h | awk ' $NF ~ /home/ {print int($5)}')
  echo "Disk usage of partation '/home' : " $DISK_USEAGE"%"
  echo "###########################################"
}

# 判断是否需要报警
function alerm() {
  if [ $LIMIT_PERCENT -lt $DISK_USEAGE ]
    then
      echo "Those service should be clean up :"
      du -sh /home/sftcwl/apps/*| awk ' $1 ~ /G/ {print $1, $2}'
      CONTENT=$(du -sh /home/sftcwl/apps/*| awk ' $1 ~ /G/ {print $2}')
      noticeWechat
  fi
}
# 企业微信报警
function noticeWechat() {
  curl 'https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=xxxxx' \
  -H 'Content-Type: application/json' \
  -d "${REQUEST_BODY/LIST/$CONTENT}"
}

cal
alerm
#echo $CONTENT
#echo "${REQUEST_BODY/LIST/$CONTENT}"
