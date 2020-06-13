# Coding-with-Java  

项目地址：[Coding-with-Java](https://github.com/CodingGorit/Coding-with-Java)
项目介绍：
> Coding-with-Java 是一个面向新手的 Java 从入门到进阶的项目，内容主要涉及 Java SE，Java EE 和 一些企业级框架的学习及使用，致力于帮助编程新手解决学习完基础语法，没有合适的项目练手。以及知识点巩固。后期会不定期更新一些面试题。此项目将会保持持续更新，目前主要由我一个人在维护


Java项目整合目录:  
一、 Java 从入门到精通笔记  
1. Java SE 篇  
2. Java EE 篇  
3. Spring 全家桶系列  
  
二、Java SE 至 Java EE系列项目整合  
1. Java SE 学习阶段项目练习
2. Java EE 学习阶段项目练习
3. Java EE 框架整合项目


# 一、Java 从入门到精通学习笔记  
see [Java 从入门到精通](https://www.yuque.com/u300253/learnjava)

Tips:
> 如果有想参与文档编写的同学，可以联系我 gorit@qq.com

### 1.1 Java SE篇 (2020 6 2 更新)
1. [JavaSE 基础语法篇](https://www.yuque.com/u300253/learnjava/java_se_01)  
    1.1 [Java 快速入门](https://www.yuque.com/u300253/learnjava/java_se_basic_01)  
    1.2 [Java变量及基础数据类型](https://www.yuque.com/u300253/learnjava/java_se_basic_02)  
    1.3 [Java 中的基本运算符](https://www.yuque.com/u300253/learnjava/java_se_basic_03)  
    1.4 [访问修饰符](https://www.yuque.com/u300253/learnjava/java_se_basic_04)  
    1.5 [流程控制 与 循环](https://www.yuque.com/u300253/learnjava/java_se_basic_05)  
    1.6 [数组的基本使用](https://www.yuque.com/u300253/learnjava/java_se_basic_06)  

2. [JavaSE 面向对象篇（类的基本结构）](https://www.yuque.com/u300253/learnjava/java_se_02)

3. [Java SE （面向对象篇 ——封装、继承、多态、抽象）](https://www.yuque.com/u300253/learnjava/java_se_03)

4. [Java 内置 API 学习](https://www.yuque.com/u300253/learnjava/java_se_04)

5. [Java 修饰符](https://www.yuque.com/u300253/learnjava/java_se_05)

6. [Java 中异常处理](https://www.yuque.com/u300253/learnjava/java_se_06)

7. [泛型与集合](https://www.yuque.com/u300253/learnjava/java_se_07)

8. [Java 的 IO 编程](https://www.yuque.com/u300253/learnjava/java_se_08)

9. [多线程编程](https://www.yuque.com/u300253/learnjava/java_se_09)

10. [Java 网络编程](https://www.yuque.com/u300253/learnjava/java_se_10)

11. [Java SE 高级特性](https://www.yuque.com/u300253/learnjava/java_se_11)

12. [Java JDBC 讲解（封装，连接池等）](https://www.yuque.com/u300253/learnjava/dpen8i)  

### 1.2 Java EE篇
1. [Servlet 篇](https://www.yuque.com/u300253/learnjava/java_ee_01)  

2. [过滤器 与 监听器](https://www.yuque.com/u300253/learnjava/java_ee_02) 

3. [JSP ](https://www.yuque.com/u300253/learnjava/java_ee_03)  

### 1.3 Spring 全家桶系列  (2020 6 2 更新)
1. [Spring 系列]()  
2. [Spring MVC 系列](https://www.yuque.com/u300253/learnjava/pqqu30)  
    2.1 [SpringMVC 第一弹](https://www.yuque.com/u300253/learnjava/pqqu30)  
    2.2 [SpringMVC 第二弹](https://www.yuque.com/u300253/learnjava/uytf6x)  
    2.3 [SpringMVC SSM 整合](https://www.yuque.com/u300253/learnjava/ckth8z)  
3. [SpringBoot 系列]()   
    3.1 [运行你的第一个 SpringBoot 程序](https://www.yuque.com/u300253/learnjava/fa4gbl)  
    3.2 [SpringBoot Web 开发整合](https://www.yuque.com/u300253/learnjava/gah719)  

# 二、项目预览   
### 2.1 Java SE 篇章
#### 2.1.1 基于 Java 实现简单的注册登录系统   
注意：   
1. 非数据库实现  
2. 使用 ArrayList 实现用户注册信息存储    

#### 2.1.2 基于 Java SE 的简单学生管理系统 Java SE 版  
1. 使用了数据库实现登录注册的功能   
2. 封装了 JDBC 实现简单的 BaseDao    
3. 使用 mysql 为数据库作为数据持久化  

### 2.2 Java EE 篇章  
#### 2.2.1 实现验证码的生成以及验证  (Java With CAPTCHA )  
verify code 由 servlet 生成  

#### 2.2.2 学生管理系统 Java EE 版本 （简易 Java Web）   
(StudentManagementAdvance  )  
> 此版本是在 JavaSE 的基础上进行了升级， 数据库不变，有三张表。可以进行简单的数据添加，修改，和删除的功能  

#### 2.2.3 Java EE 之简易购物车项目  (ShoppingMall)
项目简介： 
> 此项目为一个简单的 Java EE 小小购物车的项目，它具有最简单的登录，购物车页面展示（分页），添加购物车，下单，付款（使用支付宝沙箱完成此操作）  

### 2.3 Struct2 hibernate spring 框架
#### 2.3.1 新增 Struct2 实现权限管理  （2020 5 19更新）  
> 使用 maven 构建 Java EE 项目，并导入 Struct2 依赖，使用 Struct2 的类拦截器实现简易的权限管理功能   

新更新了如下功能   
1. Ajax + JSON 格式数据返回  
2. 实现文件上传 + 下载功能  
3. 提供 struct2 生成验证码的功能   

#### 2.3.2 新增 Struct2 + hibernate 整合项目 (2020 6 2更新)   
1. 使用 Struct2 框架实现 MVC 的功能   
2. 使用 hibernate 实现 ORM 的功能    
3. 以学生管理系统为例，整合两个框架的使用    

#### 2.3.3 新增 struct2 + hibernate5 + Spring5 整合项目 （2020 6 14日更新）  
1. 一个 SSH 项目快速开发脚手架  
2. 项目采用 idea + Maven 搭建
3. 项目采用了一个简单的登录示例演示 SSH 整合的实现
