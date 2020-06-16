package cn.gorit.pojo;

import java.util.Objects;

public class OrderPojo {
    private int id;
    private String orderNumber;
    private CustomerPojo customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public CustomerPojo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerPojo customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPojo orderPojo = (OrderPojo) o;
        return id == orderPojo.id &&
                Objects.equals(orderNumber, orderPojo.orderNumber) &&
                Objects.equals(customer, orderPojo.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, customer);
    }
}
