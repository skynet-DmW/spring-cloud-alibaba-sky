# spring-cloud-alibaba-sky
spring-cloud-alibaba的demo

# 版本说明
Spring Cloud Alibaba Version：2.2.4.RELEASE

Sentinel Version：1.8.0

Nacos Version：1.4.1

RocketMQ Version：4.4.0

Dubbo Version：2.7.8

Seata Version：1.3.0

1. Spring-Cloud-Alibaba版本说明：https://github.com/alibaba/spring-cloud-alibaba/wiki/版本说明

3. SpringCloudAlibaba中文社区地址: https://github.com/alibaba/spring-cloud-alibaba/blob/master/README-zh.md

2. SpringCloudAlibaba官方文档：https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/en-us/index.html

# nacos
启动命令：startup.sh -m standalone

账户&密码：nacos、nacos

# sentinel
启动命令：
- java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.0.jar

账户&密码：sentinel、sentinel
