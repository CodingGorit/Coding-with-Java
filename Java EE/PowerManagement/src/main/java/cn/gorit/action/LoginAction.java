package cn.gorit.action;

import cn.gorit.dao.Impl.UserDaoImpl;
import cn.gorit.dao.UserDao;
import cn.gorit.entity.User;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class LoginAction {
    private User u;

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
    UserDao dao = new UserDaoImpl();

    // 登录验证
    public String checkLogin() {
        System.out.println("账户：" + u.getUsername() + " 密码：" + u.getPassword());
        ActionContext ac = ActionContext.getContext(); // struct2 相当于 session
        Map<String, Object> session = ac.getSession();
        String power = "";
        User user  = dao.selectUserByNameAndPwd(u.getUsername(),u.getPassword());
        int status = user.getStatus();
        session.put("status",status);// 获取用户的权限
        if (user.getId() != null) {
            if (status == 1) {
                power = "普通用户";
            } else if (status == 2){
                power = "系统管理员";
            } else if (status == 3) {
                power = "系统维护员";
            }
            session.put("power",power);
            session.put("user",user.getUsername());
            return "success";
        } else {
            session.put("msg","你的账户输入有误，请重新输入");
            return "wrong";
        }
//        return "aaa";
    }
}
