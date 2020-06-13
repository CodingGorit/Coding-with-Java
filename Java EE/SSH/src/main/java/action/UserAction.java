package action;

import com.opensymphony.xwork2.ActionContext;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.UserService;

import java.util.Map;

// 使用 Controller 表示这是控制层，使用 ua 表示这个类被 Spring 所管理
@Controller("ua")
public class UserAction {
    // 编写两个属性，使用 struts2 的 ognl 表达式可以直接接收到前端穿过来的数据，不再需要 request.getParameter("xxxx") 接收数据了
    private String username;
    private String password;

    // 调用业务层的方法
    @Autowired
    private UserService us;

    // get 方法可以不要， set 方法必须有，不然前端的数据就无法注入进来
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

    // 编写登录逇控制层方法
    public String login() {
        System.out.println(username + " " + password); // 打印穿过来的数据
        ActionContext ac = ActionContext.getContext();
        // 得到 servlet 中的三大域的 session 域，在这里我们要将数据保存至 session，并在前端展示
        Map<String,Object> session = ac.getSession(); // 我们可以看到 session 的实质就是一个 map
        User user = us.checklogin(username,password); // 登录验证
        if ( user!=null ) {
            session.put("user",username);
            return "success";
        } else {
            return "error";
        }
    }
}
