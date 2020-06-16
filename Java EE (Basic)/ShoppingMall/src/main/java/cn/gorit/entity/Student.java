package cn.gorit.entity;

public class Student {
    private Integer sid;
    private String sname;
    private Integer sage;
    private String sgender;

    public Student(Integer sid, String sname, Integer sage, String sgender) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.sgender = sgender;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", sgender='" + sgender + '\'' +
                '}';
    }
}
