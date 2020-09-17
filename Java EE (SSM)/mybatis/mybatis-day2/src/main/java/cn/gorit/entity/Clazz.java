package cn.gorit.entity;

public class Clazz {
    private int cno;
    private String cname;

    public Clazz(int cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }



    public Clazz(String cname) {
        this.cname = cname;
    }

    public Clazz() {
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                '}';
    }
}
