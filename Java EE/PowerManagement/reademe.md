### 一、项目基本介绍  
1. 项目系统拥有三种用户类型  
    1. 普通用户 （只具备信息查询的功能）  
    2. 系统管理员 （只具备查询，添加，和修改的功能）  
    3. 系统维护员 （具备所有功能，增删改查）  
    4. 一些关键信息要隐藏  
    
2. 项目基本逻辑  
    1. 具备最基本的登录功能   
    2. 具备数据展示功能  
    3. 项目侧重于权限管理功能，所以（增加，修改，删除功能并没有去实现）  
    
### 二、项目环境搭建  
1. 开发工具 idea 2019 专业版, jdk 1.8  
2. 数据库 MySQL 5.7， 数据库可视化工具  SqlYog  
3. 使用 Maven 工具构架一个 Java Web 项目，并添加   Struct2 的依赖, 见 pom.xml  
4. 第三方 jar 包：jstl-1.2.jar + standard.jar + mysql   5.1.10 版本驱动  
5. 服务器版本：Tomcat 9  
6. 其他 Struct2 配置文件， BootStrap 支持  

### 三、项目结构搭建  
#### 3.1 前端 + 后端结构  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200519104331964.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
#### 3.2 前端主要页面  
1. 登录界面  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200519104554441.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
2. 主页  
![3.](https://img-blog.csdnimg.cn/20200519104616762.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
3. 查询页面，其他页面类似  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200519104637671.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
4. 权限不足时，禁止访问页面    
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200519104701948.png)   
#### 3.3 后端核心逻辑实现 （使用 struct2 拦截功能）
1. web.xml 配置 struct2 的过滤器  

```xml
<web-app>
  <display-name>Archetype Created Web Application</display-name>
  <filter>
    <filter-name>struts2</filter-name>
    <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
  </filter>

  <filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>*</url-pattern><!-- /*过滤所有路径    * -->
  </filter-mapping>

  <welcome-file-list>
    <welcome-file>login.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```

2. structs.xml 配置  

主要配置拦截器  
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC "-//Apache Software Foundation//DTD Struts Configuration 2.1//EN" "http://struts.apache.org/dtds/struts-2.1.dtd">
<struts>
	<package name="aaaa" namespace="/" extends="struts-default">
<!--		配置一个拦截器-->
		<interceptors>
			<interceptor name="m1" class="cn.gorit.interceptor.UserInterceptor"></interceptor>
		</interceptors>
		
		<!-- 账户验证 -->
		<action name="checkLogin" class="cn.gorit.action.LoginAction" method="checkLogin">
			<result name="success" type="redirect">/index.jsp</result>
			<result name="wrong" type="redirect">/login.jsp</result>
		</action>
		
		<!-- 获取数据库中的所有用户信息 -->
		<action name="getAllUser" class="cn.gorit.action.UserManagerAction" method="getAllUser">
			<result name="success" type="redirect">/show.jsp</result>
		</action>
		
		<!-- 添加用户，这里就要设置对应的拦截器了 -->
		<action name="addUser" class="cn.gorit.action.UserManagerAction" method="addUser">
			<result name="success" type="redirect">/addUser.jsp</result>
			<result name="error" type="redirect">/error.jsp</result>
			<interceptor-ref name="m1"></interceptor-ref>
			<!-- 手动配置拦截器 -->
			<interceptor-ref name="defaultStack"></interceptor-ref>
		</action>
		
		<!-- 删除用户 -->
		<action name="deleteUser" class="cn.gorit.action.UserManagerAction" method="deleteUser">
			<result name="success" type="redirect">/deleteUser.jsp</result>
			<result name="error" type="redirect">/error.jsp</result>
			<interceptor-ref name="m1"></interceptor-ref>
			<!-- 手动配置拦截器 -->
			<interceptor-ref name="defaultStack"></interceptor-ref>
		</action>
		
		<!-- 修改用户 -->
		<action name="updateUser" class="cn.gorit.action.UserManagerAction" method="updateUser">
			<result name="success" type="redirect">/editUser.jsp</result>
			<result name="error" type="redirect">/error.jsp</result>
			<interceptor-ref name="m1"></interceptor-ref>
			<!-- 手动配置拦截器 -->
			<interceptor-ref name="defaultStack"></interceptor-ref>
		</action>

	</package>
	<constant name="struts.enable.DynamicMethodInvocation" value="true"></constant>
</struts>    
```
3. 编写用户管理的逻辑 UserManagerAction  

```java
package cn.gorit.action;

import cn.gorit.dao.Impl.UserDaoImpl;
import cn.gorit.dao.UserDao;
import cn.gorit.entity.User;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Map;

// 用户管理
public class UserManagerAction {

    // 获取所有用户的操作
    public String getAllUser() {
        System.out.println("获取所有的用户~");
        ActionContext ac = ActionContext.getContext(); // struct2 相当于 session
        Map<String, Object> session = ac.getSession();
        UserDao dao = new UserDaoImpl();
        ArrayList<User> list = dao.queryAllUser();
        session.put("list",list);
        return "success";
    }

    public String addUser() {
        System.out.println("添加用户的操作~");
        ActionContext ac = ActionContext.getContext(); // struct2 相当于 session
        Map<String, Object> session = ac.getSession();
        UserDao dao = new UserDaoImpl();
        ArrayList<User> list = dao.queryAllUser();
        session.put("list",list);
        int status = (int) session.get("status");
        if (status == 2 || status == 3) {
            return "success";
        }
        return "error";
    }

    public String deleteUser() {
        System.out.println("删除用户的操作~");
        ActionContext ac = ActionContext.getContext(); // struct2 相当于 session
        Map<String, Object> session = ac.getSession();
        UserDao dao = new UserDaoImpl();
        ArrayList<User> list = dao.queryAllUser();
        session.put("list",list);
        int status = (int) session.get("status");
        if (status == 3) {
            return "success";
        }
        return "error";
    }

    public String updateUser() {
        System.out.println("更新用户的操作~");
        System.out.println("删除用户的操作~");
        ActionContext ac = ActionContext.getContext(); // struct2 相当于 session
        Map<String, Object> session = ac.getSession();
        UserDao dao = new UserDaoImpl();
        ArrayList<User> list = dao.queryAllUser();
        session.put("list",list);
        int status = (int) session.get("status");
        if (status == 2 || status == 3) {
            return "success";
        }
        return "error";
    }

}

```

4. 编写类拦截器  

```java
package cn.gorit.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

// 类户拦截器
public class UserInterceptor extends AbstractInterceptor {
	// 拦截器在上面的 structs.xml 都配置了
    @Override
    public String intercept(ActionInvocation arg0) throws Exception {
        System.out.println("拦截器开始工作了~");
        String str = "error";
        ActionContext ac = arg0.getInvocationContext();
        Map<String,Object> session = ac.getSession();
        str = arg0.invoke();
        if (str.equals("error")) {
            session.put("error","你的权限不足，禁止访问该页面");
        }
        return str ;
    }
}
```  
5. 然后前端访问 UserManagerAction  的特定方法，会根据用户的 status 是否有 “有资格” 进行操权限操作，如果没有权限请求就会被拦截，跳转至 error.jsp 界面  