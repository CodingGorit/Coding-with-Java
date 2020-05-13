@[toc](基于 Java EE 阶段的小型购物车项目)  

麻雀虽小，五脏俱全，UI 写的比较 low，这个就不要太在意了  
# 一、项目搭建  
1. 构建一个 Java Web 项目  
2. 数据库 mysql 5.7 版本  
3. 开发工具 idea 2019， sqlyog  
4. 服务器版本 Tomcat 9.0.34  
5. 涉及到第三方 JAR 包：  
	- mysql 驱动 5.1.44 版本以上  
	- Tomcat 的所有 lib 包支持  
	- jstl 1.2 标签库支持  
	- 支付宝 SDK 提供的  jar 包  
6. 其他：  
	- BootStrap 库支持  
	- Jquery 库支持 （完成 ajax 操作）  

# 二、商品界面展示  
### 2.1 登录界面  
用户需要输入正确的账号密码，以及验证码，经后端校验通过即可通过   
- 验证码由后端生成，验证码点击图片或者 文字 都可以通过 js 进行交换  
- 用户名  ajax 校验  
- 没有编写注册功能，因为我比较懒 hhhh  
![在这里插入图片描述](https://img-blog.csdnimg.cn/202005131434362.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,  color_FFFFFF,t_70)  
### 2.2 商城主页  
1. 用户登录成功就会进入该界面，用户登录信息经过 session 域进行保存  
2. 商品界面采用了 分页处理  
3. 用户可以选择将商品添加至购物车 或者直接查询购物车  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513143651972.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513143859989.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
### 2.3 购物车页面  
1. 用户选中项目可以对数量进行 添加 和 修改，修改的数据会通过 ajax 传至后台进行同步修改（这样做并不是合理，所以有点小 bug）  
2. 商品如果不想要点击删除，会通过 ajax 进行删除，然后页面的 dom 也会删除，但是有个小 个 bug，因为没有对数据进行重新查询，所以，页面会恢复原样，但是数据库的数据是已经删除了该购物车信息了  
3. 因为数据是动态渲染出来的，所以我使用 Jquery 完成购物车的 js 逻辑时，可能会有些小 bug， 所以我只用了一个产品进行购物  
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020051314400842.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
### 2.4 确认支付环节  
1. 支付采用了支付宝的沙箱环境，我们需要配置一些信息到 沙箱页面 和自己的本地环境即可完成沙箱环境接入  

这个页面其实可以直接跳过去的，不知道为啥就写进来了  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513144645619.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
### 2.5 真正的支付环境了  
这里可以看到前面购物车的账单信息  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513144753297.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
这里就和真真的支付没啥关系了，但是千万别傻乎乎的用自己的支付宝付钱，因为支付宝的沙箱环境已经提供了虚拟卖家账号 和 虚拟商家账号了，在这里我们可以快乐的充值，体验一把有钱人的快乐，也可以下载对应的沙箱环境支付宝进行支付  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513144921613.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
和真实的支付环境基本有区别  
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020051314531957.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
# 三、后端重点  
### 3.1 数据库设计  
这个 小小商城 只用到了三张表，总体逻辑也不是很复杂  

#### 3.1.1 用户表 （user）  
这是单独的一张表  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513145526537.png)  

#### 3.1.2 商品表 （product）  
用于显示对应的数据  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513145559300.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
#### 3.1.3 购物车（Shopcart）  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513145730509.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
### 3.2 Java Web 后端逻辑难点分析  
#### 3.2.1 验证码实现  
使用 java 的 2d 绘图工具，绘制一张 png，我的代码对验证码的绘制做了比较好的封装，所以看起来比较舒服  

```java
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 生成一个 6位数的验证码，并存放到 session 域中 valiCode
 * 并通过 response 返回
 * */
@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
    private Random random = new Random();
    private int width = 80;//宽度
    private int height = 40;//高度
    private int fontsize = 20;//字体大小
    private String str = "0123456789abcdefghijklmnxnlopiiqusdakljnalwABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //----------- 简单版本 -------------
    private String randCode() { //生成 4个字符 随机字符串代码
        String code = "";
        for (int i=0; i<4; i++) {
            code +=str.charAt(random.nextInt(str.length()));
        }
        return code;
    }

    //------------ 生成至少四个字符的随机字符串 --
    private String randCode1(int len) {
        if (len < 4) {
            len = 4;
        }
        //更改宽度
        width = 5 + fontsize*len ;
        String code = "";
        for (int i=0; i<len; i++) {
            code +=str.charAt(random.nextInt(str.length()));
        }
        return code;
    }

    //-------------  返回随机字符串的颜色
    private Color randColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r,g,b);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置 servlet 的显示类型
        response.setContentType("image/png");
        // 2. 大致设置一个虚拟的验证码
        //1. 创建画板
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.创建画笔
        Graphics2D pen = (Graphics2D)img.getGraphics();
        //3.生成随机内容
        String code = randCode1(4); //生成 4位数验证码
        System.out.println(code);
        request.getSession().setAttribute("valiCode", code); //保存 code到 session,和后面的内容对应

        //4.绘制内容
        //	4.1 设置绘制区域
        pen.fillRect(0, 0, width, height);
        //	4.2设置字体
        pen.setFont(new Font("微软雅黑",Font.BOLD,fontsize));
        //	4.3 按顺序逐个绘制字符
        for (int i = 0;i<code.length();i++) {
            pen.setColor(randColor());//每个字符使用不同的颜色
            //绘制字符
            //code.charAt(i) 获得的是单个字符，因此加一个 "" 使其变成字符串
            pen.drawString(code.charAt(i)+"", 5+i*fontsize,(fontsize + height)/2);
        }

        //	4.4 绘制噪音线  ------------------ 增加验证码难度
        for (int i = 0;i < 2;#### i++) {
            pen.setColor(randColor());//设置画笔颜色
            pen.setStroke(new BasicStroke(3));//设置线条为 3个像素
            //划线的坐标：x1,y1 x2,y2
            pen.drawLine(random.nextInt(width/2), random.nextInt(height), random.nextInt(width), random.nextInt(width));
        }
        //5.存为图片并发送
        ServletOutputStream out = response.getOutputStream();//数据通过 response 返回
        ImageIO.write(img, "png", out);
        out.flush();//缓存刷新
        out.close();//缓存关闭
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
```  
#### 3.2.2 分页逻辑实现    
分页逻辑实际就是对数据库的数据进行分条查询，选择 mysql 数据库，是因为它有较好的分页逻辑  
1. 我们需要一个参数 pageNo 表示当前是第几页的数据，这个我们需要从前端获取，如果是第一次获取，就得给一个默认值  
2. 再给一个 pageSize ，表示每页固定展示的数据的条数  
3. 再给一个 count ，代表数据库中数据的总记录数，所以这里需要进行聚合查询的（**select count(*) from xxx**） 的到总记录数  
4. 还没完，还需要一个 pageCount，这个值代表当前页面能显示多少条数据，也是从后端数据库进行获取的  
	> 给大家举一个例子，假设我的数据库里有 11 条记录，也就是第一次展示前 5条，当我们要看第二页的时候就查询第 6 到 10条数据，在翻页就是查询最后一页的数据，因此这个 pageCount 是需要计算的，每次查询出来的数据，告诉前端要显示几条数据  

计算逻辑：  

```java
        int pageCount = 0;
        if (count%pageSize == 0) {
            pageCount = count/pageSize;
        } else {
            pageCount = count/pageSize+1;
        }
```

5. 数据库分页查询语句：`select * from xxx limit pageSize*(pageNo-1), pageSize`  这样就可以做到上面的例子的逻辑  

前端的分页逻辑，采用 BootStrap 的分页标签 + jstl 标签库 共同实现分页逻辑  

```html
        <nav>
            <ul id="pagination" class="pagination">
                <c:choose>
                    <c:when test="${pageNo>1}">
                        <li class="page-item"><a class="page-link" href="GetAllServlet?pageNo=${pageNo-1 }">上一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="javascript:void(0);">上一页</a></li>
                    </c:otherwise>
                </c:choose>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <c:choose>
                    <c:when test="${pageNo<pageCount}">
                        <li class="page-item"><a class="page-link" href="GetAllServlet?pageNo=${pageNo+1 }">下一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="javascript:void(0);">下一页</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
```

#### 3.2.3 支付宝沙箱支付环境接入  
当时在接入的时候，也踩了比较多的坑，现在我把我的解决方案分享给大家（**如果嫌麻烦，可以直接到 我的Github 仓库下载这个 购物车的小 demo，里面都是 配置好了的**）  

1. 下载 支付宝手机支付 API 的 SDK，我们是 Java 开发者，当然要下载 java 的 SDK：[手机网站支付 SDK](https://opendocs.alipay.com/open/54/106682)   
2. 然后可以大致预览一下支付宝接入流程：[接入流程](https://opendocs.alipay.com/open/291/106103)  
3. 然后登陆支付宝开放平台，填写配置，不然后续就无法进行接入的相关工作  
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020051315353249.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
4. 阅读沙箱环境支付接入流程：[沙箱支付接入介绍](https://opendocs.alipay.com/open/200/105311)  
5. 沙箱环境页面介绍：  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513153838674.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
6. 然后是下载签名工具：[签名工具使用](https://opendocs.alipay.com/open/291/106103)  

下载好就是这样子的  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513154110331.png)  

因为我们是个人开发者，没有企业的资质，所以无法生成证书的，所以就默认点这个就可以了  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513154243949.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
然后将生成的公钥添加到 沙箱环境的应用公钥里，就算是和支付宝环境接入完成了。  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513154444218.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
7. 然后是 java 代码配置  
将下载好的 sdk导入我们的项目  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513154604990.png)  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513154843927.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513155148243.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  

这里替换上面两个对应密钥  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513155240608.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  
到这里就基本配置完成了，然后根据你的项目逻辑进行修改即可  

8. 差点忘记了，我们还需要将 SDK 提供的 jar 包导入进来  
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513160045968.png)  

# 四、总结  
学到这里 jsp 阶段也算是告一段落了，目前是在学习 Vue 前端 + 后端 SpringBoot 交互的一些内容，目前进度，大爱 Vue，希望下次的项目能够做的更加精彩，加油  

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200513155820646.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)  