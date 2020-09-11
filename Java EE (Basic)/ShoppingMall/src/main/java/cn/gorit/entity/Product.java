package cn.gorit.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;
    private String product_name;
    private Double price;
    private String inroduce;
    private String address;

    public Product() {
    }

    public Product(Integer id, String product_name, Double price, String inroduce, String address) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.inroduce = inroduce;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getInroduce() {
        return inroduce;
    }

    public void setInroduce(String inroduce) {
        this.inroduce = inroduce;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
