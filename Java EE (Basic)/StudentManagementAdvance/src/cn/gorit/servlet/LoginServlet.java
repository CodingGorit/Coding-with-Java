package cn.gorit.servlet;

import cn.gorit.dao.impl.StudentDaoImpl;
import cn.gorit.entity.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        // 得到账户密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ServletContext application = request.getServletContext();
        HttpSession session = request.getSession();

        // 用户验证
        int res = new StudentDaoImpl().Login(username,password);

        ArrayList<Student> list = new StudentDaoImpl().queryStudents();
        if (res > 0) {

            // 访问统计
            User logineduser = new User(username,password);
            session.setAttribute("LOGINED_USER",logineduser);

            List loginerdUsers = new ArrayList(); // 访问这列表
            if (application.getAttribute("LOGINED_USER") != null) {
                loginerdUsers = (List) application.getAttribute("LOGINED_USER");
            }
            loginerdUsers.add(logineduser); // 把新登录的用户信息存入访问者列表中
            application.setAttribute("LOGINED_USER", loginerdUsers);

            // 把可以代表登录的信息
            Cookie c = new Cookie("accessMsg",username);
            c.setMaxAge(300);
            //发送到客户端进行保存
            response.addCookie(c);
//            session.setAttribute("username",username);
            application.setAttribute("list",list);
        } else {
            request.setAttribute("msg","账号或密码不正确");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        response.sendRedirect("show.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
