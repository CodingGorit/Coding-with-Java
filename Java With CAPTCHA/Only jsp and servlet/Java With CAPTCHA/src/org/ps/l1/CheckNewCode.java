package org.ps.l1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.awt.RepaintArea;

/**
 * @author: Gorit
 * @see readme.nd
 * @version 1.0.0
 * @date 2019年12月19日21:00:53
 */
@WebServlet("/CheckNewCode")
public class CheckNewCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckNewCode() {
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
		//1.得到数据
		String inCode = request.getParameter("inCode").toString().toLowerCase();//获取前端界输入的数据是否合理,变成字符串以及小写字符串
		String valiCode = request.getSession().getAttribute("valiCode").toString().toLowerCase();//获取前面 session 中保存的数据
		//2.验证是否合理
		if (inCode.equals(valiCode)) {
			request.setAttribute("msg", "Hello World");
			response.sendRedirect("loginSuccess.jsp");//重定向
		} else {
			request.getSession().setAttribute("err", "验证码输入错误，请重新输入");
			//返回上一页
			String url = request.getHeader("Referer");
			response.sendRedirect(url);
		}
	}

}
