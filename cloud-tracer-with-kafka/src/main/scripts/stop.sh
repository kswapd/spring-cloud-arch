#!/bin/bash
cd `dirname $0`
cd ..
DEPLOY_DIR=`pwd`
LIB_DIR=$DEPLOY_DIR/lib
CONF_DIR=$DEPLOY_DIR/config
SERVER_NAME="cloud-tracer-with-kafka"
SERVER_PORT=21111
IS_LISTENED=`netstat -an | grep -w LISTEN | grep -w $SERVER_PORT`
if [ -z "$IS_LISTENED" ]; then
    echo "ERROR: The $SERVER_NAME[$SERVER_PORT] does not started!"
    exit 1
fi

PIDS=`ps -ef | grep "$LIB_DIR" | awk '{print $2}'`
echo -e "Stopping the $SERVER_NAME ...\c"

COUNT=2
while [ $COUNT -lt 1 ]; do
    for PID in $PIDS ; do
        kill $PID > /dev/null 2>&1
    done
    echo -e ".\c"
    sleep 3
	IS_LISTENED=`netstat -an | grep -w LISTEN | grep -w $SERVER_PORT`
	if [ -z "$IS_LISTENED" ]; then
		COUNT=1
	fi
done

echo "OK!"
echo "PID: $PIDS"