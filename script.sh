#!/bin/bash
SERVICE="/servers/demo.jar"
if pgrep -f demo.jar > /dev/null
then
    pkill -9 -f demo.jar
else
    echo "$SERVICE stopped"
fi
