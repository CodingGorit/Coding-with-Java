# Coding-with-Java 项目

一个正经的介绍：这里属于 **Java从入门到精通到全栈** 文档中附属的 **项目篇**  

 😎😎😎 同步更新 => [传送门](https://www.yuque.com/u300253/learnjava)   

 😍😍😍 如果有想参与文档编写的同学，可以通过如下唯一方式联系我 javafullstack2021@163.com  

 🤭🤭🤭 致力于帮助每一位学习 Java 的同学构建出自己的学习体系  

 觉得不错的，帮忙点个 star 吧！！！

---
## 一、Java 笔记

由于篇幅过长，我对笔记进行了拆分 @see [README-yuque-notes.md](https://github.com/CodingGorit/Coding-with-Java/blob/master/README-yuque-notes.md)

## 二、Java 项目篇（看对应的分支）
### 2.1 Java SE 篇章（见 Java-SE）
#### 2.1.1 基于 Java 实现简单的注册登录系统

1. 非数据库实现  
2. 使用 ArrayList 实现用户注册信息存储
3. 项目结构已经大改 —— 2021年12月2日

#### 2.1.2 基于 Java SE 的简单学生管理系统 Java SE 版

1. 使用了数据库实现登录注册的功能
2. 封装了 JDBC 实现简单的 BaseDao
3. 使用 mysql 为数据库作为数据持久化

### 2.2 Java EE 篇章（见Java-EE（Basic））

> 对应 Java-EE（Basic）分支
#### 2.2.1 实现验证码的生成以及验证  (Java With CAPTCHA)

verify code 由 servlet 生成  

#### 2.2.2 学生管理系统 Java EE 版本 （Java Web + CRUD）

(StudentManagementAdvance)  
> 此版本是在 Java SE 的基础上进行了升级， 数据库不变，有三张表。可以进行简单的数据添加，修改，和删除的功能  

#### 2.2.3 Java EE 之简易购物车项目  (ShoppingMall)

> 此项目为一个简单的 Java EE 小小购物车的项目，它具有最简单的登录，购物车页面展示（分页），添加购物车，下单，付款（使用支付宝沙箱完成此操作）  

#### 2.2.4 JavaEE login demo（2022年6月18日）

> > 基于 MVC 模式实现的 登录 和 查询功能，通过 session 对非法访问的进行处理

### 2.3 Java EE 企业级框架篇  

> Java-EE（SSH）分支
#### 2.3.1 Struct2 hibernate spring 框架 （Java-EE（SSH））
##### 一、 Struct2 实现权限管理  （2020 5 19更新）  

> 使用 maven 构建 Java EE 项目，并导入 Struct2 依赖，使用 Struct2 的类拦截器实现简易的权限管理功能   

新更新了如下功能   

1. Ajax + JSON 格式数据返回  
2. 实现文件上传 + 下载功能  
3. 提供 struct2 生成验证码的功能   

##### 二、新增 Struct2 + hibernate 整合项目 (2020 6 2更新)   

1. 使用 Struct2 框架实现 MVC 的功能   
2. 使用 hibernate 实现 ORM 的功能     
3. 以学生管理系统为例，整合两个框架的使用    

##### 三、 新增 struct2 + hibernate5 + Spring5 整合项目 （2020 6 14日更新）  

1. 一个 SSH 项目快速开发脚手架  
2. 项目采用 idea + Maven 搭建
3. 项目采用了一个简单的登录示例演示 SSH 整合的实现     

### 2.4 Spring SpringMVC MyBatis 框架 （JavaEE-SSM）  

> Java-EE（SSM）分支
#### 2.4.1 Spring

1. day1-ioc
2. day2-aop

#### 2.4.2 SpringMV

1. SpringMVC-day1
2. SpringMVC-day2

#### 2.4.3 MyBatis （2020年9月17日 更新）

1. mybatis-day1 （环境搭建+crud+xml）  
2. mybatis-day2 （高级用法）

#### 2.4.4 SSM 整合  （2020年9月17日 更新）

1. SSM （Spring5 + SpringMVC + MyBatis + c3p0）  注解开发
2. SSM （Spring5 + SpringMVC + MyBatis + Druid） XML + 注解开发

#### 2.4.5 SSM project

| 项目 | 主要技术栈 | 主要功能 | 添加时间 |
| :---: | --- | --- | :---: |
| his_ssm | JSP + Spring5 + SpringMVC + mybatis + BootStrap + mysql8 | 登陆、退出登陆、注册、单表 CRUD、模糊查询。下拉框动态加载数据，分页显示 | 2023/06/28 |

### 2.5 SpringBoot (2020 6 16 更新 —— SpringBoot 分支)

> Java-EE（SpringBoot）分支
#### 2.5.1 advanced （高级整合篇）

1. SpringBoot 整合 ElasticSearch
    - SpringBoot-es-api es api 的学习
    - SpringBoot-es-jd 京东爬虫实战搜索
2. SpringBoot 整合定时任务
3. SpringBoot 整合 WebSocket

#### 2.5.2 SpringBoot 整合持久层  （2020 11 9新增 SpringBoot 整合 MongoDB）

>  SpringBoot 整合持久层相关

1. 整合 JdbcTemplate   
2. 整合 MyBatis    
3. 整合 Spring Data JPA   
4. 整合 Spring Data JPA  构建 REST API   
5. 整合 MyBatis-plus
6. 整合 多数据源 （MyBatis + Druid）
7. 整合 redis 
8. 整合 mongoDB
  
#### 2.5.3 SpringBoot 全局处理配置  （2020 10 9） 

1. SpringBoot 配置全局异常处理   
2. SpringBoot 整合 Java 配置类   
3. SpringBoot 整合 Swagger2     
4. SpringBoot 整合 aop 
  
#### 2.5.4 SpringBoot 整合安全框架 （2020 8 17）

1. SpringBoot 整合 Shiro 框架  
2. SpringBoot 整合 JWT 框架   

#### 2.5.5 templates 模板语法 （2020 10 23）

模板语法看看也好

1. SpringBoot + tyhmeleaf + jpa 实现的 CRUD  

#### 2.5.6 application （应用）

对应 SpringBoot 应用篇  

1. SpringBoot 防止表单重复提交
2. SpringBoot 整合邮件发布 

PS： 实际上 SpringBoot 的项目远比这个更多

#### 2.5.7 springboot projects (实战项目)

1. 实习生管理系统 (vue2后台 + springboot后端)
2. 个人单体博客系统 (vue2后台 + vue2前台 + springboot 后端)

## 三、更新记录

- SpringBoot 新增实战练手项目 —— 2023年7月15日

- master 分支 README 格式梳理，语雀笔记相关内容 迁移到 README-yuque-notes.md —— 2023年6月29日

- JavaSSM (JavaEE-SSM 分支) 新增 his_ssm 案例，适合期末大作业（主要功能：登陆、退出登陆、注册、单表 CRUD、模糊查询。下拉框动态加载数据，分页显示）—— 2023年6月28日

- JavaSSM 新增案例代码，对应原文 [AOP 注解专题](https://www.yuque.com/gorit/learnjava/wc4rsg/edit#THePM) —— 2023年2月12日

- JavaEE 新增 login demo 案例 （JavaEE（Basic）分支）—— 2022年6月18日

- 每个分支对应不同的项目添加对应 .gitignore, 修改 master 分支 README - 2022年6月11日

- 删除 master 分支中，java se 中的项目，JavaSE 项目需要去 Java-SE 分支去看 - 2022年6月8日

- 中间断更是因为，大四毕业上班去了 hhhhh，我又活过来了，这次来我是把 GOF 的部分已经更新完了，同时开始梳理每个项目 -2021年12月2日

- 更新 GOF 文档，优化分支内容，更新 readme，更新 Spring Cloud Alibaba 文档 - 2021年6月21日

- 更新了 GOF 设计模式板块，增加了 GOF 分支 - 2021年1月13日。后序考虑增加 SpringCloudAlibaba

- 更新了 SpringBoot 整合 MongoDB - 2020年11月9日

- 更新了部分学习笔记内容，主要修改 master 分支内容，新增 SpringBoot 项目模块 — 2020年10月23日

- 更新了 SpringBoot 整合 WebSocket，并且修改部分分支内容 —— 2020年10月9日

- 更新了 SpringBoot 整合多数据源（MyBatis + Druid） —— 2020年9月20日

- 更新了 JavaEE（SSM）部分内容 —— 2020年9月17日

- 项目更新了分支，大家可以根据需要下载对应的部分 —— 2020年8月

