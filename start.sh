#!/bin/bash
nohup java -jar -Xms512m -Xmx512m -XX:NewRatio=2 -XX:MaxDirectMemorySize=1024m $(cd `dirname $0`;pwd)/demo.jar --spring.profiles.active=test --server.port=9081   > $(cd `dirname $0`;pwd)/nohup.out 2>&1  &

