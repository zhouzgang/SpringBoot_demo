### spring cloud 整体把握

##### 1. spring 是什么？
  Spring Cloud是一系列构建分布式系统的框架的有序集合。

##### 2. spring 有什么作用？


##### 3. spring 由什么组成？

- `Spring Cloud Netflix`: 与各种Netflix OSS组件集成，组成微服务的核心
    - `Netflix Eureka`: 服务中心，云端服务发现，一个基于 REST 的服务，用于定位服务，以实现云端中间层服务发现和故障转移。
    - `Netflix Hystrix`: 熔断器，容错管理工具，旨在通过熔断机制控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。
    - `Netflix Zuul`: Zuul 是在云平台上提供动态路由,监控,弹性,安全等边缘服务的框架。
    - `Netflix Archaius`: 配置管理API，包含一系列配置管理API，提供动态类型化属性、线程安全配置操作、轮询框架、回调机制等功能。
- `Spring Cloud Config`: 俗称的配置中心，配置管理工具包，让你可以把配置放到远程服务器，集中化管理集群配置，目前支持本地存储、Git以及Subversion     
- `Spring Cloud Bus`: 事件、消息总线，用于在集群（例如，配置变化事件）中**传播状态变化**，可与Spring Cloud Config联合实现热部署。
- `Spring Cloud for Cloud Foundry`: Cloud Foundry是VMware推出的业界第一个开源PaaS云平台
- `Spring Cloud Cluster`: 提供在分布式系统中的集群所需要的基础功能支持，如：选举、集群的状态一致性、全局锁、tokens等常见状态模式的抽象和实现。
- `Spring Cloud Consul`: Consul 是一个支持多数据中心分布式高可用的服务发现和配置共享的服务软件
- `Spring Cloud Security`: 基于spring security的安全工具包，为你的应用程序添加安全控制。
- `Spring Cloud Sleuth`: 日志收集工具包，封装了Dapper和log-based追踪以及Zipkin和HTrace操作，为SpringCloud应用实现了一种分布式追踪解决方案。
- `Spring Cloud Data Flow`: 为基于微服务的分布式流处理和批处理数据通道提供了一系列模型和最佳实践。
- `Spring Cloud Stream`: 是创建消息驱动微服务应用的框架
- `Spring Cloud Task`: 主要解决短命微服务的任务管理，任务调度的工作，比如说某些定时任务晚上就跑一次，或者某项数据分析临时就跑几次。
- `Spring Cloud Starters`: Spring Boot式的启动项目，为Spring Cloud提供开箱即用的依赖管理。
- `Spring Cloud CLI`: 基于 Spring Boot CLI，可以让你以命令行方式快速建立云组件。
  

##### 4. 组件各自的作用？


##### 5. 学习资料