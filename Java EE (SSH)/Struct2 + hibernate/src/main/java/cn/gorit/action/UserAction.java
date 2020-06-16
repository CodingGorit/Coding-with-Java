package cn.gorit.action;

import cn.gorit.dao.Impl.StudentDaoImpl;
import cn.gorit.dao.Impl.UserDaoImpl;
import cn.gorit.dao.StudentDao;
import cn.gorit.dao.UserDao;
import cn.gorit.entity.Student;
import cn.gorit.entity.User;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class UserAction {
    private User u;


    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public String checkLogin () {
        System.out.println("账户:" + u.getUsername() + " 密码：" + u.getPassword());
        ActionContext ac = ActionContext.getContext(); // struct2 构造缘生意的 session
        Map<String, Object> session = ac.getSession();
        UserDao dao = new UserDaoImpl();
        int res = dao.selectUserByNameAndPwd(u.getUsername(), u.getPassword());
        if (res > 0) {
            session.put("user",u.getUsername());
            return "success";
        }
        session.put("msg","账号或密码错误，请重新登录");
        return "error";
    }


}
