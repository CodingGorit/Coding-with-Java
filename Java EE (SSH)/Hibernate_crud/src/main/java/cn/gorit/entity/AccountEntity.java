package cn.gorit.entity;

import java.io.Serializable;
import java.util.Objects;

public class AccountEntity implements Serializable {
    private Integer id;
    private String name;
    private Double money;

    public AccountEntity(Integer id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public AccountEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return id == that.getId() &&
                Objects.equals(name, that.getName()) &&
                Objects.equals(money, that.getMoney());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, money);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
