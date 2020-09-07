package cn.gorit.entity;

import java.util.Objects;

public class ClasszEntity {
    private String stuId;
    private String grade;
    private String clasz;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClasszEntity that = (ClasszEntity) o;
        return Objects.equals(stuId, that.stuId) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(clasz, that.clasz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, grade, clasz);
    }
}
