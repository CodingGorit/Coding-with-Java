package cn.gorit.action;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class VerifyCodeAction {
    // 图片流
    public ByteArrayInputStream inputStream;
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


    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(ByteArrayInputStream inputStream) {
        this.inputStream = inputStream;
    }

    // 产生验证码
    public String execute() throws IOException {
        // 1. 获取画笔工具
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.创建画笔
        Graphics2D pen = (Graphics2D)img.getGraphics();
        //3.生成随机内容
        String code = randCode1(4); //生成 4位数验证码
        System.out.println(code);

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
        for (int i = 0;i < 2;i++) {
            pen.setColor(randColor());//设置画笔颜色
            pen.setStroke(new BasicStroke(3));//设置线条为 3个像素
            //划线的坐标：x1,y1 x2,y2
            pen.drawLine(random.nextInt(width/2), random.nextInt(height), random.nextInt(width), random.nextInt(width));
        }

        pen.dispose();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        JPEGImageEncoder jpeg= JPEGCodec.createJPEGEncoder(bos);
        jpeg.encode(img);
        inputStream=new ByteArrayInputStream(bos.toByteArray());
        return "success";
    }
}
