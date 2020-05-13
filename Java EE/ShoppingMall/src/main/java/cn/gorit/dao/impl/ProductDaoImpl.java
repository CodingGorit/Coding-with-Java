package cn.gorit.dao.impl;

import cn.gorit.dao.ProductDao;
import cn.gorit.entity.Product;
import cn.gorit.util.BaseDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao {
    BaseDao db = new BaseDao();
    // 查询所有的商品
    @Override
    public ArrayList<Product> queryProducts() {
        try {
            PreparedStatement ps = db.getConnect("select * from product");
            ResultSet rs = ps.executeQuery();
            Product product = null;
            ArrayList<Product> list = new ArrayList<Product>();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
                product = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5));
                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
