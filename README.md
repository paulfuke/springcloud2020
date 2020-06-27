## 学习springCloud2020
### springcloud2020 组件选用
> 1,Eureka停用,可以使用zk作为服务注册中心，也可以使用consul（不推荐），强烈推荐Nacos可以完美替换Eureka

> 2,服务调用,Ribbon准备停更,代替为LoadBalance(还不太成熟),
 
> 3,服务调用Feign要改为OpenFeign
 
> 4,服务降级、熔断Hystrix停更,改为resilence4j（老外）或者阿里巴巴的sentienl （国内--推荐）
 
> 5.Zuul改为gateway

> 6,服务配置Config改为  Nacos（阿里）或者appllo（携程）

> 7,服务总线Bus改为Nacos
