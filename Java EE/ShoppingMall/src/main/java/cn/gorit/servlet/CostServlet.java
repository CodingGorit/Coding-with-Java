package cn.gorit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CostServlet")
public class CostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("进入结算界面");
        int money = Integer.valueOf(request.getParameter("money"));
        System.out.println(money);
        HttpSession session = request.getSession();
        session.setAttribute("money",money);
        session.setAttribute("product","商品");
        response.sendRedirect("pay.jsp");
    }
}
