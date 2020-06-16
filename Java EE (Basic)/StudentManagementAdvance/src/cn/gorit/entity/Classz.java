package cn.gorit.entity;

// 代表班级表
public class Classz {
    private String grade; // 年级
    private String clasz; // 班级

    public Classz(String grade, String clasz) {
        this.grade = grade;
        this.clasz = clasz;
    }

    public Classz() {
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClasz() {
        return clasz;
    }

    public void setClasz(String clasz) {
        this.clasz = clasz;
    }

    @Override
    public String toString() {
        return this.grade + " " + this.clasz;
    }
}
