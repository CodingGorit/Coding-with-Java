package com.example.entity;

public class Student {
    private Integer id;
    private String sname;
    private Integer sage;
    private String sgender;

    public Student(String sname, Integer sage, String sgender) {
        this.sname = sname;
        this.sage = sage;
        this.sgender = sgender;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", sgender='" + sgender + '\'' +
                '}';
    }
}

