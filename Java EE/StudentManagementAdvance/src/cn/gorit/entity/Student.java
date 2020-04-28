package cn.gorit.entity;

public class Student {
    private String stuId;
    private String stuName;
    private int stuAge;
    private String classz; // 学生所在 年级 班级

    public Student(String stuId, String stuName, int stuAge, String classz) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.classz = classz.toString();
    }



    public Student() {
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getClassz() {
        return classz;
    }

    public void setClassz(String classz) {
        this.classz = classz;
    }

    @Override
    public String toString() {
        return stuId +"\t"+stuName+"\t"+stuAge+"\t"+classz.toString();
    }
}
