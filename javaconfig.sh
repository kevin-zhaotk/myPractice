#!/bin/sh

HOME_PATH=$1
echo "java home path $HOME_PATH"

export CLASSPATH=$HOME_PATH/lib:$HOME_PATH/jre/lib
export $CLASSPATH
export JAVA_HOME=$HOME_PATH
export $JAVA_HOME
export JRE_HOME=$HOME_PATH/jre
export $JRE_HOME
export PATH=$PATH:$HOME_PATH/bin:$HOME_PATH/jre/bin
