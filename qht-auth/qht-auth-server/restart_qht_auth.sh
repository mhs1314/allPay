#!/bin/sh
JAVA_OPTS='-Xms128m -Xmx512m -XX:NewSize=128m -XX:MaxNewSize=512m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m -XX:NewRatio=2 -XX:MaxTenuringThreshold=8 -XX:+DisableExplicitGC'
dir=`cd "$( dirname "$0" )" && pwd`
qht_jar=qht-auth.jar
RESOURCE_NAME=${dir}/target/${qht_jar}
LOG_NAME=/home/qht-auth.log
NG="zh_CN.UTF-8"
pid=`ps ax | grep ${qht_jar} | grep java | head -1 | awk '{print $1}'`
echo $pid
kill -9 $pid

sleep 3
echo '服务停止成功,开始重启服务...'

nohup java -jar ${RESOURCE_NAME} >> ${LOG_NAME} 2>&1 &
rm -rf tpid
echo Start Success!