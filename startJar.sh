#!/bin/bash

user=`whoami`

if [ "$user" == "root" ];then
    echo 'script can not run under root user !!!!!'
    exit
fi


# stop process if exist
key=toolbox
pid=`ps -ef|grep -w $key |grep -v grep|grep -v tail|awk '{print $2}'`
originalUser=`ps -ef|grep -w $key |egrep -v "grep|log"|awk '{print $1}'`

# 杀掉原进程
while  [ -n "$pid" ]
do
    echo "kill -9 $pid"
    kill -9 $pid
    sleep 1
    pid=`ps -ef|grep -w $key |egrep -v "grep|log"|awk '{print $2}'`
done


sleep 5
# logs目录与jarDir目录同级
cd /opt/jarServer
cd ..

# 修改原来的日志文件名
oiginalCurrentLogFlie=./logs/toolbox.log
if [ ! -f "$oiginalCurrentLogFlie" ]; then
    echo "No need change original log file name."
else
    timeStr=`date +%Y-%m-%d-%H-%M`
    newLogFileName=toolbox-logs-$timeStr-restart.log
    mv ./logs/toolbox.log ./logs/$newLogFileName
fi

# $BASEDIR
#if [ ! -d ./log ];then mkdir -p ./log;fi

source /etc/profile

# timeStr=`date +%Y-%m-%d-%H-%M`
# logfileName="$timeStr".log

cd /opt/jarServer
# java   -jar toolbox.jar 2>&1|tee ./log/current_run.log > ./log/$logfileName &
sleep 5