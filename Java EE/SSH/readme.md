# 使用前必读  
1. 此项目是 Java EE 中 SSH 框架的整合    
2. 项目采用 maven 构建    
3. 数据库采用 mysql 5.7版本    

> 该项目使用前需要将 文件中的 db_userl.sql 导入你的数据库中，然后根据的数据库名称，修改 src/main/resources/jdbc.properties 中的数据库配置，然后就可以运行试一试了~

最近要使用 SSH 来编写期末的考核任务，之前也在网上查阅了很久，也试出了很多的问题。也很感谢很多前辈们的总结，我也查到了很多用用的内容。

本次项目，我将以一个简单的登录案例实现 SSH 的项目整合，项目我会放到 Github 上面，需要的同学可以 clone 下来在本地跑一跑。  
  
接下来就是从 0 教大家搭建  SSH 项目, 目录如下  

```xml
一、项目环境搭建  
    1.1 配置 Spring 坐标依赖  
    1.2 配置 hibernate 坐标依赖  
    1.3 配置 struts2 坐标依赖  
    1.4 配置Java EE 坐标依赖    
    1.5 其他工具  
二、项目结构搭建  
    2.1 配置文件  
    2.2 包结构   
三、编写配置文件  
    3.1 web.xml 文件配置  
    3.2 编写 jdbc.properties 文件  
    3.3 编写 applicationContext.xml 配置文件  
    3.4 struts 配置文件  
四、使用 hibernate 逆向生成工具生成实体  
    4.1 配置数据库连接信息  
    4.2 逆向生成实体类  
    4.3 实体类配置  
五、JavaBean 编写  
    5.1 编写 dao 层  
    5.2 编写 Service 层  
    5.3 编写 Controller 层 （UserAction）  
    5.4 编写 struts 路由映射  
六、前端界面编写  
    6.1 登录界面编写  
    6.1 登录成功  
    6.3 登录失败  
```

# 一、项目环境搭建
使用 maven 搭建一个 Java Web 项目
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613202740881.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)

### 1.1 配置 Spring 坐标依赖
引入 Spring 坐标依赖

```xml
 <!-- spring-context -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.1.0.RELEASE</version>
    </dependency>
    <!-- spring-web -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>5.1.0.RELEASE</version>
    </dependency>
    <!--spring-jdbc -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>5.1.0.RELEASE</version>
    </dependency>
    <!-- spring-orm -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-orm</artifactId>
      <version>5.1.0.RELEASE</version>
    </dependency>
    <!-- aop面向切面依赖的jar包 -->
    <!-- aspectjrt -->
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjrt</artifactId>
      <version>1.9.1</version>
    </dependency>
    <!-- aspectjweaver -->
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
      <version>1.9.1</version>
    </dependency>
```

### 1.2 配置 hibernate 坐标依赖
我们的目标是要整合 SSH，所以需要 hibernate 的核心依赖， mysql 数据库驱动，以及 c3p0 数据库连接池
```xml
   <!-- hibernate核心依赖 -->
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>5.2.17.Final</version>
    </dependency>
    <!-- mysql数据库驱动依赖 -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.47</version>
    </dependency>
        <!-- c3p0连接池 -->
    <dependency>
      <groupId>com.mchange</groupId>
      <artifactId>c3p0</artifactId>
      <version>0.9.5.2</version>
    </dependency>
```

### 1.3 配置 struts2 坐标依赖
我们需要 struts 核心，以及 struts 整合 spring 的插件，以及 struts 对 json 数据处理的插件

```xml
    <!-- struts2 -->
    <dependency>
      <groupId>org.apache.struts</groupId>
      <artifactId>struts2-core</artifactId>
      <version>2.3.35</version>
    </dependency>
    <!-- struts2-spring-plugin整合spring和struts2 -->
    <dependency>
      <groupId>org.apache.struts</groupId>
      <artifactId>struts2-spring-plugin</artifactId>
      <version>2.3.35</version>
    </dependency>
    <!-- json 数据处理，struts 插件 -->
    <dependency>
      <groupId>org.apache.struts</groupId>
      <artifactId>struts2-json-plugin</artifactId>
      <version>2.3.8</version>
    </dependency>
```
### 1.4 配置Java EE 坐标依赖
这里可以引入 servlet api，jstl 标签库等一系列工具

```xml
<!-- servlet api -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>javax.servlet.jsp-api</artifactId>
      <version>2.3.1</version>
      <scope>provided</scope>
    </dependency>
    <!-- lombok 一个插件，可以免 getter 和 setter 方法，但是需要我们在 idea 中装对应的插件才可以使用，可以不要-->
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.0</version>
      <scope>provided</scope>
    </dependency>
    <!-- jstl -->
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>
```
### 1.5 其他工具
json 处理工具

```xml
      <dependency>
          <groupId>org.jetbrains</groupId>
          <artifactId>annotations-java5</artifactId>
          <version>RELEASE</version>
          <scope>compile</scope>
      </dependency>
    <!-- 官方给的 json 包，建议使用这个，但是我后面好像并没有用到 -->
    <dependency>
      <groupId>org.json</groupId>
      <artifactId>json</artifactId>
      <version>20160810</version>
    </dependency>
```
# 二、项目结构搭建
### 2.1 配置文件
使用如下方式创建
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020061320454922.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)


1. applicationContext.xml
2. jdbc.properties
3. struts.xml

### 2.2 包结构
创建如下的基本包结构
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613210631124.png)

# 三、编写配置文件
### 3.1 web.xml 文件配置
```xml
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <display-name>Archetype Created Web Application</display-name>

  <context-param>
    <param-name>contextConfigLocation</param-name>
    <!-- Spring 的配置文件-->
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <!-- struts2核心过滤器，过滤所有的请求 -->
  <filter>
    <filter-name>struts2</filter-name>
    <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
  <!-- 上下文监听器 -->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
</web-app>
```
### 3.2 编写 jdbc.properties  文件
这里我们需要自己手动修改数据库的信息配置
```properties
jdbc.driverClass=com.mysql.jdbc.Driver
jdbc.jdbcUrl=jdbc:mysql://localhost:3306/hibernate?characterEncoding=utf-8&autoReconnect=true&useSSL=false
jdbc.user=root
jdbc.password=root
#连接池中保留的最小连接数
jdbc.minPoolSize=1
#连接池中保留的最大连接数
jdbc.maxPoolSize=20
#初始化连接数
jdbc.initialPoolSize=1
```

### 3.3 编写 applicationContext.xml 配置文件
这里面也包含了数据库的基本配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd 
       http://www.springframework.org/schema/tx 
       http://www.springframework.org/schema/tx/spring-tx.xsd 
       http://www.springframework.org/schema/context 
       http://www.springframework.org/schema/context/spring-context.xsd">
    
    <!-- 引入资源文件 -->
    <context:property-placeholder location="classpath:jdbc.properties"/>
    <!-- 自动扫描与装配bean-->
    <context:component-scan base-package="dao.*,service.*"/>
    <context:component-scan base-package="action"/>
    <!--引入注解解析器-->
    <context:annotation-config/>
    <!-- 数据源连接池 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driverClass}"/>
        <property name="jdbcUrl" value="${jdbc.jdbcUrl}"/>
        <property name="user" value="${jdbc.user}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="minPoolSize" value="${jdbc.minPoolSize}"/>
        <property name="maxPoolSize" value="${jdbc.maxPoolSize}"/>
        <property name="initialPoolSize" value="${jdbc.initialPoolSize}"/>
    </bean>
    <bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="hibernateProperties">
            <props>
                <!--配置Hibernate的方言-->
                <prop key="hibernate.dialect">
                    org.hibernate.dialect.MySQLDialect
                </prop>
                <prop key="hibernate.hbm2ddl.auto">update</prop>
                <prop key="hibernate.current_session_context_class">thread</prop>
                <!--格式化输出sql语句-->
                <prop key="hibernate.show_sql">true</prop>
                <prop key="hibernate.format_sql">true</prop>
                <prop key="hibernate.use_sql_comments">false</prop>
            </props>
        </property>
        <!-- 自动扫描实体 -->
        <property name="packagesToScan"  value="entity" />
    </bean>
    <!-- 配置 HibernateTemplate 对象 -->

    <bean id="hibernateTemplate" class="org.springframework.orm.hibernate5.HibernateTemplate">
        <!-- 注入 SessionFactory 对象 -->
        <property name="sessionFactory" ref="sessionFactory"/>
    </bean>

    <!-- 用注解来实现事务管理 -->
    <bean id="txManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory"/>
    </bean>
    <tx:annotation-driven transaction-manager="txManager"/>
</beans>
```

### 3.4 struts 配置文件
我们还没有编写的具体的 action 服务，所以这里先跳过

# 四、使用 hibernate 逆向生成工具生成实体
### 4.1 配置数据库连接信息
使用 idea 自带的数据库连接的工具
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613211326708.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
完善基本配置信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613211402186.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
### 4.2 逆向生成实体类
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613211457796.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613211525704.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613211650963.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
### 4.3 实体类配置
生成好后可以看到和数据库对应的实体类，我的表很简单，一个简单的用户表，只有 id， username， password 字段
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613211750988.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)

但是我们发现里面的部分内容会爆红，这是因为我们没有指定数据源
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613211930183.png)
选择我们刚才连接的数据库
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613211950975.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
然后就没问题了。

# 五、JavaBean 编写
看到包结构，大家应该可以猜出来，我是使用的典型的 MVC 三层架构来编写的
### 5.1 编写 dao 层
创建 **UserDao** 以及 它的实现类 **UserDaoImpl**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613212628103.png)

UserDao 编写
```java
package dao;

import entity.User;

public interface UserDao {

    // 用户登录验证
    public User selectByUsernameAndPassword(String username, String password);
}
```

UserDaoImpl 

```java
package dao.Impl;

import dao.UserDao;
import entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

// 使用 Spring 来接管持久层的所有操作
@Repository
public class UserDaoImpl implements UserDao {

    // 使用 Hibernate 提供的模板
    @Autowired
    @Resource
    private HibernateTemplate hibernateTemplate;

    // 生成对应的 get 和 set 方法
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        // 登录的逻辑不算难，就是使用 sql 语句查询，username 和 password 两个字段是否存在即可,我们使用的是 hibernate 框架，所以要写 hql 语句
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Query q = session.createQuery("from User u where u.username = ? and u.password = ?");
        q.setParameter(0,username);
        q.setParameter(1,password);
        User u = (User) q.uniqueResult();
        return u;
    }
}
```

我们写好了 dao 层，这时候发现出现了爆红的问题，这里我们需要手动添加项目的依赖信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613213946745.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
点击 project structure
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613214031106.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613214204384.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
添加这个就可以了，问题就解决了
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613214335523.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
显示正常了
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613214426929.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
### 5.2 编写 Service 层
同样，我们创建对应的 **UserService** 和 对应的 **UserServiceImpl** 类

有的同学可能会问道，不就是一个简单的登录功能嘛，有必要这么麻烦吗？是的，这么做确实没必要，但是随着项目的越来越大，只有把具体的功能全部分开来做，这样才不至于整个项目太过于乱

编写用户的业务层 接口 **UserService**

```java
package service;

import entity.User;

public interface UserService {
    // 登录验证
    User checklogin(String username, String password);
}
```

编写 业务层对应的实现类 **UserServiceImpl**

```java
package service.Impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    // 这里业务层调用持久层的方法
    @Autowired
    private UserDao ud;
    
    @Override
    public User checklogin(String username, String password) {
        return ud.selectByUsernameAndPassword(username,password);
    }
}
```

### 5.3 编写 Controller 层 （UserAction）
这里的逻辑思路，是 controller 层 调用 service 的方法，service 层调用 dao 层的方法

```java
package action;

import com.opensymphony.xwork2.ActionContext;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.UserService;

import java.util.Map;

// 使用 Controller 表示这是控制层，使用 ua 表示这个类被 Spring 所管理
@Controller("ua")
public class UserAction {
    // 编写两个属性，使用 struts2 的 ognl 表达式可以直接接收到前端穿过来的数据，不再需要 request.getParameter("xxxx") 接收数据了
    private String username;
    private String password;

    // 调用业务层的方法
    @Autowired
    private UserService us;

    // get 方法可以不要， set 方法必须有，不然前端的数据就无法注入进来
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 编写登录逇控制层方法
    public String login() {
        System.out.println(username + " " + password); // 打印穿过来的数据
        ActionContext ac = ActionContext.getContext();
        // 得到 servlet 中的三大域的 session 域，在这里我们要将数据保存至 session，并在前端展示
        Map<String,Object> session = ac.getSession(); // 我们可以看到 session 的实质就是一个 map
        User user = us.checklogin(username,password); // 登录验证
        if ( user!=null ) {
            session.put("user",username);
            return "success";
        } else {
            return "error";
        }
    }
}
```
### 5.4 编写 struts 路由映射
记得在 Project Structure 添加如下配置
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200613231109812.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)

stucts  action 配置
```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
        "http://struts.apache.org/dtds/struts-2.3.dtd">

<struts>

    <package name="user" namespace="/" extends="struts-default">
        <action name="checklogin" class="ua" method="login">
        	<!-- 登录成功挑战至首页 -->
            <result name="success" type="redirect">/index.jsp</result>
            <!-- 登录失败跳转至错误页面 -->
            <result name="error" type="redirect">/error.jsp</result>
        </action>
    </package>
</struts>
```
# 六、前端界面编写
### 6.1 登录界面编写

```html
<%--
  Created by IntelliJ IDEA.
  User: Gorit
  Date: 2020/6/13
  Time: 23:18
  Contact: gorit@qq.com
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="checklogin" method="post">
        <label for="username">账户：</label>
        <input type="text" name="username" id="username"><br>
        <label for="password">密码：</label>
        <input type="password" name="password" id="password"><br>
        <input type="submit" value="登录">
    </form>

</body>
</html>

```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200614002828510.png)
### 6.1 登录成功

```html
<%--
  Created by IntelliJ IDEA.
  User: Gorit
  Date: 2020/6/13
  Time: 23:21
  Contact: gorit@qq.com
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>欢迎你 ${sessionScope.user} 登录!!</h3>
</body>
</html>

```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200614002934899.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200614002954781.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
### 6.3 登录失败

```html
<%--
  Created by IntelliJ IDEA.
  User: Gorit
  Date: 2020/6/13
  Time: 23:21
  Contact: gorit@qq.com
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>出错啦！！！</h2>
</body>
</html>

```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200614003016692.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200614003055495.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)