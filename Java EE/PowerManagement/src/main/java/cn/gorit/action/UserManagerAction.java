package cn.gorit.action;

import cn.gorit.dao.Impl.UserDaoImpl;
import cn.gorit.dao.UserDao;
import cn.gorit.entity.User;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Map;

// 用户管理
public class UserManagerAction {

    // 获取所有用户的操作
    public String getAllUser() {
        System.out.println("获取所有的用户~");
        ActionContext ac = ActionContext.getContext(); // struct2 相当于 session
        Map<String, Object> session = ac.getSession();
        UserDao dao = new UserDaoImpl();
        ArrayList<User> list = dao.queryAllUser();
        session.put("list",list);
        if (session.get("user") == null) {
            session.put("msg","你还为登录，请登录");
            return "fail";
        }
        return "success";
    }

    public String addUser() {
        System.out.println("添加用户的操作~");
        ActionContext ac = ActionContext.getContext(); // struct2 相当于 session
        Map<String, Object> session = ac.getSession();
        UserDao dao = new UserDaoImpl();
        ArrayList<User> list = dao.queryAllUser();
        session.put("list",list);
        int status = (int) session.get("status");
        if (status == 2 || status == 3) {
            return "success";
        }
        if (session.get("user") == null) {
            session.put("msg","你还为登录，请登录");
            return "fail";
        }
        return "error";
    }

    public String deleteUser() {
        System.out.println("删除用户的操作~");
        ActionContext ac = ActionContext.getContext(); // struct2 相当于 session
        Map<String, Object> session = ac.getSession();
        UserDao dao = new UserDaoImpl();
        ArrayList<User> list = dao.queryAllUser();
        session.put("list",list);
        int status = (int) session.get("status");
        if (status == 2) {
            return "success";
        }
        if (session.get("user") == null) {
            session.put("msg","你还为登录，请登录");
            return "fail";
        }
        return "error";
    }

    public String updateUser() {
        System.out.println("更新用户的操作~");
        ActionContext ac = ActionContext.getContext(); // struct2 相当于 session
        Map<String, Object> session = ac.getSession();
        UserDao dao = new UserDaoImpl();
        ArrayList<User> list = dao.queryAllUser();
        session.put("list",list);
        int status = (int) session.get("status");
        if (status == 2 || status == 3) {
            return "success";
        }
        if (session.get("user") == null) {
            session.put("msg","你还为登录，请登录");
            return "fail";
        }
        return "error";
    }

}
