package cn.gorit.entity;

import javax.persistence.*;

/**
 * @Entity 注解表示该类是一个实体类，在项目启动时，会根据该类自动生成一张表，表的名称及 name 的名称，没有默认为类名
 * @Id 表示是一个主键，@GeneratedValue 表示主键自动生成，strategy  则表示生成策略
 * 默认情况下，生成的表的字段的名称就是实体类中属性的名称，通过 @Column 自定义生成字段的属性，name 表示该字段在数据库的名称， nullable 表示是否为空
 * @Transient 表示数据库生成表时，忽略该字段，即不生成字段。
 * */
@Entity(name = "t_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_name",nullable = false)
    private String name;

    private String author;

    private Double price;

    @Transient
    private  String description;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
