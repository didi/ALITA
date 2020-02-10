#!/bin/bash
source /etc/profile

cd `dirname $0`
JVM_ARGS="-Xms2g -Xmx2g -server -XX:+UseConcMarkSweepGC -XX:MaxTenuringThreshold=15 -XX:+UseParNewGC -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -Duser.timezone=GMT+8 -Djavax.servlet.request.encoding=UTF-8 -Dfile.encoding=UTF-8 -Duser.language=zh_CN -Dsun.jnu.encoding=UTF-8"
### 调试模式 下面这行必须配置，如果是预发环境端口号必须在8000 ~ 8100范围之内
JVM_DEBUG_ARGS="-Xdebug -Xrunjdwp:transport=dt_socket,suspend=n,server=y,address=8079"
PACKAGE_NAME="alita.jar"
PID=$(ps aux | grep ${PACKAGE_NAME} | grep -v grep | awk '{print $2}' )

# 从输入获取环境变量及启动参数
if [ -n "${2}" ]; then
    PROFILE=$2
    if [ $# -gt 2 ]; then
        index=0
        JVM_ARGS=""
        # 去掉前2个参数，拼接启动参数
        for i in $*; do
            let index+=1
            if [ ${index} -gt 2 ];then
                JVM_ARGS="${JVM_ARGS} $i"
            fi
        done
    fi
else
    PROFILE="dev"
fi

function check_if_process_is_running {
  if [ "$PID" = "" ]; then
    return 1
  fi
  ps -p ${PID} | grep "java"
  return $?
}

function checkProfile {
  local cluster_file=".deploy/service.cluster.txt"
  if [ -f "$cluster_file" ];then
      cluster=`cat ${cluster_file}`
      if [[ ${cluster} =~ "-pre" ]];then
          PROFILE="pre"
      else
          PROFILE="prod"
      fi
  else
    echo "找不到Cluster文件"
  fi
}

function start {
  if [ "$PID" != "" ] && check_if_process_is_running
  then
      echo  "${PACKAGE_NAME}正在运行"
      exit 1
  fi
    echo "开始启动"
    # 创建日志目录
          mkdir -p var &>/dev/null
          nohup java -jar ${JVM_ARGS} -Dspring.profiles.active=${PROFILE} ${PACKAGE_NAME}  >nohup.out 2>&1 &
    echo "启动成功"
    return $?
}

function stop {
  if ! check_if_process_is_running
  then
    echo "${PACKAGE_NAME}已经停止"
    exit 0
  fi
  kill -9 ${PID}
  echo  "等待进程停止"
  for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20; do
    if check_if_process_is_running
    then
      NOT_KILLED=1
      echo  "等..."
      sleep 1
    else
      NOT_KILLED=0
    fi
  done
  if [ ${NOT_KILLED} = 1 ]
  then
    echo  "杀不掉进程"
    exit 1
  fi
echo  "${PACKAGE_NAME}已经停止"
}

function restart {
stop
start
exit $?
}

case $1 in
    start )
      start
    ;;
    stop )
      stop
    ;;
    restart )
     restart
    ;;
    * )
      echo "ERROR:./control.sh start|stop prod|qa|dev|pre JVM_ARGS"
    ;;
esac
exit $?
