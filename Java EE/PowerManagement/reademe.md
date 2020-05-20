# 使用 Struct2 框架的拦截器 实现权限管理功能
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
3. 使用 Maven 工具构架一个 Java Web 项目，并添加 Struct2 的依赖, 见 pom.xml
4. 第三方 jar 包：jstl-1.2.jar + standard.jar + mysql 5.1.10 版本驱动
5. 服务器版本：Tomcat 9
6. 其他 Struct2 配置文件， BootStrap 支持

### 三、项目结构搭建
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200519104331964.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  


### 四、更新记录 （2020 5 21）
1. Ajax + JSON 格式数据返回  
2. 实现文件上传 + 下载功能  
3. 提供 struct2 生成验证码的功能  
