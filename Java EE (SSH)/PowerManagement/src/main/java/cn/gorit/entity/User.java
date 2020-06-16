package cn.gorit.entity;

public class User {
    private Integer id;
    private String username;
    private String password;
    private int status = 1; // 普通用户1 系统管理员 2 系统维护员 3

//    public User(Integer id, String username, String password, int status) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.status = status;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
