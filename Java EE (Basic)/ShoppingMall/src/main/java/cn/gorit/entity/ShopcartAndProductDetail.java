package cn.gorit.entity;

//中间实体（没有对应的表）  作用：承载数据
public class ShopcartAndProductDetail {
    private int shopNO;
    private String productName;
    private double price;
    private int num;

    public ShopcartAndProductDetail() {
    }

    public ShopcartAndProductDetail(int shopNO, String productName, double price, int num) {
        this.shopNO = shopNO;
        this.productName = productName;
        this.price = price;
        this.num = num;
    }

    public int getShopNO() {
        return shopNO;
    }

    public void setShopNO(int shopNO) {
        this.shopNO = shopNO;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
