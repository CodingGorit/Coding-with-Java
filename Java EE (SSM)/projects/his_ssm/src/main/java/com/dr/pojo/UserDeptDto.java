package com.dr.pojo;

public class UserDeptDto extends User {
    private String deptName;

    @Override
    public String getDeptName() {
        return deptName;
    }

    @Override
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "UserDeptDto{" +
                "deptName='" + deptName + '\'' +
                '}';
    }
}
