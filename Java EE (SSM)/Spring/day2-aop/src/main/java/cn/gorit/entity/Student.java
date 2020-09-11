package cn.gorit.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("s1")
public class Student {
    @Value("20171212332")
    private String sno;
    @Value("张三")
    private String sname;

//    Autowired 默认使用 byType实现自动注入
//    如果出现两个 bean 需要使用 Autowired 进行自动注入的话。我们则需要在 Component 中指定 bean 的名称，使其变成 byName 进行注入
    @Autowired
    private Clazz cls;


    public Student(String sno, String sname, Clazz cls) {
        this.sno = sno;
        this.sname = sname;
        this.cls = cls;
    }

    public Student() {
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Clazz getCls() {
        return cls;
    }

    public void setCls(Clazz cls) {
        this.cls = cls;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", cls=" + cls +
                '}';
    }
}
