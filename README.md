# Spring-Cloud-Alibaba-Sky
spring-cloud-alibaba的demo

# jar包版本说明
Spring Cloud Alibaba Version：2.2.4.RELEASE

Nacos Version：1.4.1

Sentinel Version：1.8.0

RocketMQ Version：4.4.0

Dubbo Version：2.7.8

Seata Version：1.3.0

1. Spring-Cloud-Alibaba版本说明：https://github.com/alibaba/spring-cloud-alibaba/wiki/版本说明

3. SpringCloudAlibaba中文社区地址: https://github.com/alibaba/spring-cloud-alibaba/blob/master/README-zh.md

2. SpringCloudAlibaba官方文档：https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/en-us/index.html

# 软件
Nacos Version：1.4.1

Sentinel Version：1.8.0

RocketMQ Version：4.8.0

# Nacos
1. Windows 启动命令
    - startup.cmd -m standalone
2. Linux 启动命令
    - startup.sh -m standalone

默认账户&密码：nacos、nacos

# Sentinel
1. Windows & Linux 启动命令：
    - java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.0.jar

默认账户&密码：sentinel、sentinel

# RocketMQ
1. Windows 启动命令
    - 设置环境变量
    - 启动 NameServer
        - start mqnamesrv.cmd
    - 启动 Broker 
        - start mqbroker.cmd -n 127.0.0.1:9876 autoCreateTopicEnable=true
        - 假如弹出提示框提示‘错误: 找不到或无法加载主类 xxxxxx’
            - 打开runbroker.cmd
            - 将set CLASSPATH=.;%BASE_DIR%conf;%CLASSPATH% 这个命令中的 %CLASSPATH% 加上英文双引号
            - 保存并重新执行start语句。

2. Linux 启动命令
    - 启动 NameServer
        - nohup sh bin/mqnamesrv &
        - tail -f ~/logs/rocketmqlogs/namesrv.log
    - 启动 Broker 
        - nohup sh bin/mqbroker -n localhost:9876 &
        - tail -f ~/logs/rocketmqlogs/broker.log

3. 控制台
    - java -jar rocketmq-console-ng-1.0.1.jar --server.port=19977 --rocketmq.config.namesrvAddr=127.0.0.1:9876
