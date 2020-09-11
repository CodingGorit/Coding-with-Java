package cn.gorit.pojo;

import java.io.Serializable;

public class StudentEntity implements Serializable {
    private String stuId;
    private String stuName;
    private Byte stuAge;
    private ClasszEntity classz;

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

    public Byte getStuAge() {
        return stuAge;
    }

    public void setStuAge(Byte stuAge) {
        this.stuAge = stuAge;
    }

    public ClasszEntity getClassz() {
        return classz;
    }

    public void setClassz(ClasszEntity classz) {
        this.classz = classz;
    }
}
