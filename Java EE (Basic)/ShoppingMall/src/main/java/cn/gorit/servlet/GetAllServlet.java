package cn.gorit.servlet;

import cn.gorit.entity.Product;
import cn.gorit.util.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//
@WebServlet("/GetAllServlet")
public class GetAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BaseDao db = new BaseDao();
        // ��ҳ pageNo = 1
        int pageNo = 1;
        String str=request.getParameter("pageNo");
        if (str != null) {
            pageNo = Integer.valueOf(str);
        }

        // ÿҳ��ʾ���������̶�ֵ
        int pageSize = 5;
        //������� (�ȴ�����)  ��ѯ���������
        int count = 0;
        try {
            PreparedStatement ps = db.getConnect("select count(*) from product");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            db.closed(ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // ÿҳ��ʾ������,���������Ƿ����
        int pageCount = 0;
        if (count%pageSize == 0) {
            pageCount = count/pageSize;
        } else {
            pageCount = count/pageSize+1;
        }

        //��ѯ���û������й��ﳵ��Ϣ
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            ps = db.getConnect("select * from product limit ?,?");
            ps.setInt(1,pageSize*(pageNo-1));
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));
            }
            db.closed(ps,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("pageNo",pageNo);
        session.setAttribute("pageCount",pageCount);
        session.setAttribute("list",list);
        response.sendRedirect("main.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
