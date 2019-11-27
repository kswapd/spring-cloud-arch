#!/bin/bash
cd `dirname $0`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/config
LIB_DIR=$DEPLOY_DIR/lib
SERVER_NAME="cloud-tracer-with-kafka"
SERVER_PORT=21111
IS_LISTENED=`netstat -an | grep -w LISTEN | grep -w $SERVER_PORT`
if [ -n "$IS_LISTENED" ]; then
    echo "ERROR: The $SERVER_NAME[$SERVER_PORT] already started!"
    exit 1
fi


LOGS_DIR=$DEPLOY_DIR/logs
if [ ! -d $LOGS_DIR ]; then
    mkdir $LOGS_DIR
fi
STDOUT_FILE=$LOGS_DIR/stdout.log

LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`
DEBUG_OPTS="-Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"

echo -e "Starting $SERVER_NAME ...\c"
JVM_OPTS="-XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=512m -Xms512m -Xmx512m -Xmn256m -Xss256k -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC"

$JAVA_HOME/bin/java $JVM_OPTS  -classpath $CONF_DIR:$LIB_JARS com.dcits.App > $STDOUT_FILE 2>&1 &

COUNT=2
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
