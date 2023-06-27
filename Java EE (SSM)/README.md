# Java EE  （SSM）

### 一、Spring 篇  

- day1-IoC
- day2-aop   
- Demo/aop-demo  包含了一个 aop 的简单实例

> 两个案例分别是 IoC、AOP 的基本实现  
 
更新记录  
- 2023年2月12日 新增 [aop 注解代码案例](https://www.yuque.com/gorit/learnjava/wc4rsg/edit#THePM)


### 二、SpringMVC 篇  

[SpringMVC 学习以笔记](https://www.yuque.com/u300253/learnjava/pqqu30)

- SpringMVC-day1   
  - 一个最简单的 SpringMVC 应用
- SpringMVC-day2
  - SpringMVC 常用注解的使用

- Demo/mvc-demo  mvc 
  - 功能 demo，整合了文件上传 和 数据检验的功能  
- Demo/Spring + SpringMVC-demo
  - Spring +  SpringMVC 实现注册登录开发，包含数据库

### 三、 MyBatis 篇 （2020年9月17日 更新）
1. mybatis-day1 （环境搭建+crud）
2. mybatis-day2 （高级特性）

### 四、SSM 整合篇

#### 4.1 Spring5 + SpringMVC + MyBatis + c3p0

做了一个 SSM 框架整合框架，包含如下基本模块   （本版本是纯注解开发！！！）  

1. Spring 使用版本锁定， 5.2.3 RELEASE  ，配置了 SpringAOP，SpringMVC  
2. 使用日志记录系统 log4j      
3. mybatis 版本为 3.4.5    
4. mysql 版本为 5.5   

更新记录:

- 新增 mybatis 打印 sql 执行日志注释 - 2023/6/28

#### 4.2 Spring5 + SpringMVC + MyBatis + Druid  （2020年9月17日 更新）

本版本使用的数据库连接池为 阿里的 Druid，并且支持 xml + 注解开发 

1. Spring 使用版本锁定， 5.2.3 RELEASE  ，配置了 SpringAOP，SpringMVC  
2. 使用日志记录系统 log4j      
3. mybatis 版本为 3.4.5    
4. mysql 版本为 5.5   

### 五、projects

小型项目实战

| 项目 | 主要技术栈 | 主要功能 | 添加时间 |
| :---: | --- | --- | :---: |
| his_ssm | JSP + Spring5 + SpringMVC + mybatis + BootStrap + mysql8 | 登陆、退出登陆、注册、单表 CRUD、模糊查询。下拉框动态加载数据，分页显示 | 2023/06/28 |

