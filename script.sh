#!/bin/bash
SERVICE="/servers/demo-1.0-SNAPSHOT.jar"
if pgrep -f demo-1.0-SNAPSHOT.jar > /dev/null
then
    pkill -9 -f demo-1.0-SNAPSHOT.jar
else
    echo "$SERVICE stopped"
fi
