package cn.gorit.entity;

public class Users {
    private String uname;
    private int uage;
    private String hobby;

    public Users(String uname, int uage, String hobby) {
        this.uname = uname;
        this.uage = uage;
        this.hobby = hobby;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uname='" + uname + '\'' +
                ", uage=" + uage +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
