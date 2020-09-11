package cn.gorit.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Clazz {

    private String cno;
    @Value("计科中软 1702")
    private String className;

    public Clazz(String cno, String className) {
        this.cno = cno;
        this.className = className;
    }

    public Clazz() {
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cno='" + cno + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
