package org.ps.l1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author: Gorit
 * @see readme.nd
 * @version 1.0.0
 * @date 2019年12月19日21:00:53
 */
//@WebServlet("/NewCode")
public class NewCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Random random = new Random();
    private int width = 80;//宽度
    private int height = 30;//高度
    private int fontsize = 12;//字体大小
    private String str = "0123456789abcdefghijklmnxnlopiiqusdakljnalw";
    
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
    
    //返回随机字符串的颜色
    private Color randColor() {
    	int r = random.nextInt(256);
    	int g = random.nextInt(256);
    	int b = random.nextInt(256);
    	return new Color(r,g,b);
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 创建画板
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//2.创建画笔
		Graphics2D pen = (Graphics2D)img.getGraphics();
		//3.生成随机内容
		String code = randCode(); //针对固定内容的产出增加难度
		request.getSession().setAttribute("valiCode", code); //保存 code,和后面的内容对应
		//4.绘制内容
		//	4.1 设置绘制区域
		pen.fillRect(0, 0, width, height);
		//	4.2设置字体
		pen.setFont(new Font("微软雅黑",Font.BOLD,fontsize));
		//	4.3按顺序逐个绘制字符
		for (int i = 0;i<code.length();i++) {
			pen.setColor(randColor());//每个字符使用不同的颜色
			//绘制字符
			//code.charAt(i) 获得的是单个字符，因此加一个 "" 使其变成字符串
			pen.drawString(code.charAt(i)+"", 5+i*fontsize,(fontsize + height)/2);
		}
		
		//	4.4 绘制噪音线  ------------------ 增加验证码难度
		for (int i = 0;i < 2; i++) {
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

}
