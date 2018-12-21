# srping boot admin + eureka + openfeign + hystrix + spring-cloud-gateway + spring-cloud-config  

使用 spring boot 2.1.1 环境  +  spring cloud version Greenwich.RC1

spring cloud 微服务的学习项目

1. spring boot admin
2. spring eureka server
3. spring cloud eureka client (启动多个实例，侦听不同端口，同一个 service id，模拟集群状况)
4. spring cloud feign 做的负载均衡（自动切换调用 3 的集群，存在从 feign 客户端访问的时候，session 丢失的问题）
5. spring cloud hystrix 做的 熔断机制
6. spring cloud gateway 做的路由机制，支持通过 spring cloud eureka client  service id 进行寻址路由的方式
    http://127.0.0.1:8766/feign-client-with-hystrix-circuitbreaker/sayHi    调用具有熔断和负载均衡的服务
    http://127.0.0.1:8766/hi-service/hi                                     直接调用一个 eureka client 的服务（多个实例，侦听不同端口），并且自动进行负载均衡，但是不具备熔断。
7. spring cloud config server                                               所有的模块的参数都通过 spring cloud config server 读取
8. spring cloud bus for rabbitmq                                            所有的模块的动态参数都通过 spring cloud bus rabbitmq 来完成参数动态热更新的功能