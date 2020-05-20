package cn.gorit.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

// 类户拦截器
public class UserInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation arg0) throws Exception {
        System.out.println("拦截器开始工作了~");
        ActionContext ac = arg0.getInvocationContext();
        Map<String,Object> session = ac.getSession();
        if (session.get("user") != null) {
            String str = "error";
            str = arg0.invoke();
            if (str.equals("error")) {
                session.put("error","你的权限不足，禁止访问该页面");
            }
            return str ;
        } else {
//               未登录
            return "fail";
        }
    }
}
