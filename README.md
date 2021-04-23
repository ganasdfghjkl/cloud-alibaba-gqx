# cloud-gqx
主要使用spring cloud alibaba 的一些主键搭建的微服务用来练手。

---

# 结构
## cloud-gqx
用来统一管理版本号
### cloud-gqx-boot 
规划为业务开发的主体项目
### cloud-gqx-entityapis
规划为dubbo服务间调用时统一定义的接口和传入返回参数的实体类的父项目。
### cloud-gqx-servers
规划为业务微服务得父项目。

--- 
## cloud-gqx-common
规划为一个公共模块，用来放置常量等信息。

---
## cloud-gqx-dependencies
规划为统一管理第三方的依赖，后期如果将starters放入私库。搭建新的微服务时，父级项目如下即可。
```mxml
<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.example</groupId>
                <artifactId>cloud-gqx-dependencies</artifactId>
                <version>${revision}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
</dependencyManagement>
```

---
## cloud-gqx-starters
规划为自定义的starter父级项目。
