package cn.gorit.dao;

import cn.gorit.entity.Product;

import java.util.ArrayList;

public interface ProductDao {
    // 查询所有的商品
    public ArrayList<Product>  queryProducts();
}
