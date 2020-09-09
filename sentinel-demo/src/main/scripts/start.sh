#!/bin/bash
cd `dirname $0`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/config
LIB_DIR=$DEPLOY_DIR/lib
SERVER_NAME="hello-service"
SERVER_PORT=`cat $CONF_DIR/bootstrap.yml | grep -w "port:" | grep -v "#" | awk  'NR==1{print $2}' | tr -d '\r'`
IS_LISTENED=`netstat -an | grep -w LISTEN | grep -w $SERVER_PORT`
if [ -n "$IS_LISTENED" ]; then
    echo "ERROR: The $SERVER_NAME[$SERVER_PORT] already started!"
    exit 1
fi


######################cloud trace##########################
TRACE_CLOUD_TRACE_URL=http://10.7.19.116:30094
TRACE_CLOUD_TRACE_PROBABILITY=1.0
TRACE_CLOUD_TRACE_ENABLED=true
#Parent dir of cloud-trace-deps-*
TRACE_DIR="/home/oms/apps"
TRACE_DIR=`ls -rd $TRACE_DIR/cloud-trace-deps* | head -1`
TRACE_LIB_DIR=$TRACE_DIR
TRACE_LIB_JARS=`ls $TRACE_LIB_DIR|grep .jar|awk '{print "'$TRACE_LIB_DIR'/"$0}'|tr "\n" ":"`
echo "Using TRACE_LIB_JARS: $TRACE_LIB_JARS"
if [ -n "$TRACE_CLOUD_TRACE_URL" ]; then
   TRACE_OPTS="-Dcloud.trace.url=$TRACE_CLOUD_TRACE_URL"
fi
if [ -n "$TRACE_CLOUD_TRACE_PROBABILITY" ]; then
   TRACE_OPTS="$TRACE_OPTS -Dcloud.trace.probability=$TRACE_CLOUD_TRACE_PROBABILITY"
fi
if [ -n "$TRACE_CLOUD_TRACE_ENABLED" ]; then
   TRACE_OPTS="$TRACE_OPTS -Dcloud.trace.enabled=$TRACE_CLOUD_TRACE_ENABLED"
fi
echo "Using TRACE_OPTS: $TRACE_OPTS"
#############################################################

LOGS_DIR=$DEPLOY_DIR/logs
if [ ! -d $LOGS_DIR ]; then
    mkdir $LOGS_DIR
fi
STDOUT_FILE=$LOGS_DIR/stdout.log

LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`
DEBUG_OPTS="-Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"

echo -e "Starting $SERVER_NAME ...\c"
JVM_OPTS="-XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=512m -Xms512m -Xmx512m -Xmn256m -Xss256k -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC"

$JAVA_HOME/bin/java $JVM_OPTS  $TRACE_OPTS -classpath $CONF_DIR:$LIB_JARS:$TRACE_LIB_JARS main.ProviderApplication > $STDOUT_FILE 2>&1 &

COUNT=0
while [ $COUNT -lt 1 ]; do 
    echo -e ".\c"
    sleep 3
    IS_LISTENED=`netstat -an | grep -w LISTEN | grep -w $SERVER_PORT`
    if [ -n "$IS_LISTENED" ]; then
        COUNT=1
    fi
done

PIDS=`ps -ef | grep "$LIB_DIR" | awk 'NR==1{print $2}'`
echo "OK!"
echo "PID: $PIDS"
echo "STDOUT: $STDOUT_FILE"
