package cn.gorit.dao;

public interface UserDao {
    public int selectUserByNameAndPwd(String username, String password);
}
