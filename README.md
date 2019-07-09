# my-cloud

1. cloud-api           eureka服务消费者
    * 通过restTemplate对不具体的指定服务提供者的ip和端口，只需要访问服务名称，可实现负载均衡
2. cloud-entities      公共模块
3. cloud-eureka        eureka注册中心集群
    * java -jar -Dport=7001 -Dspring.profiles.active=7001 cloud-eureka-0.1.0.jar
    * java -jar -Dport=7002 -Dspring.profiles.active=7002 cloud-eureka-0.1.0.jar
    * java -jar -Dport=7003 -Dspring.profiles.active=7003 cloud-eureka-0.1.0.jar
4. cloud-provider      eureka服务提供者
    * java -jar -Dport=8001 cloud-provider-0.1.0.jar
    * java -jar -Dport=8002 cloud-provider-0.1.0.jar
