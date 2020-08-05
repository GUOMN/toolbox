#!/bin/bash
# 总磁盘占用报警阈值（百分比）
LIMIT_PERCENT=75
# 单个文件夹报警大小阈值(GB)
LIMIT_DISK_SIZE=1.5

DISK_USEAGE=0
CONTENT=""

# 计算磁盘占用情况
function cal() {
  DISK_USEAGE=$(df -h | awk ' $NF ~ /home/ {print int($5)}')
  echo "Disk usage of partation  /home:""$DISK_USEAGE""%"
  echo "###########################################"
  echo "Those service should be clean up :"
  du -sh /home/sftcwl/apps/* | awk '$1~/G/ && $1+0>'${LIMIT_DISK_SIZE}' {print $1, $2}'
  # 报警时同时列举文件大小超过1G的工程目录
  CONTENT=$(du -sh /home/sftcwl/apps/* | awk '$1~/G/ && $1+0>'${LIMIT_DISK_SIZE}' {print $1, $2}')
}
# 判断是否需要报警
function alarm() {
  # 磁盘利用率超过指定比例（$LIMIT_PERCENT）或者某个文件加大小超过1G 报警
  if [[ $LIMIT_PERCENT -lt $DISK_USEAGE ]] || [[ $CONTENT != "" ]]
    then
      noticeByWechat
      echo "触发报警！"
  fi
}
# 企业微信报警
function noticeByWechat() {
  curl 'https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=xxx' \
  -H 'Content-Type: application/json' \
  -d "{ \"msgtype\": \"text\", \"text\": {\"content\": \"4041磁盘占用${DISK_USEAGE}%, 以下服务请尽快清理工作目录: \n${CONTENT}\",\"mentioned_mobile_list\":[\"@all\"]}}"
}
# 清理文件
function cleanUp() {
  sh /home/sftcwl/apps/inventory/clean_up.sh;
}

# 主入口
cal
alarm