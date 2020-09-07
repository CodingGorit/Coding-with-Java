package cn.gorit.interceptors;

import cn.gorit.util.JWTUtil;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 JWT 拦截器, 拦截器的实现
 */

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求头中的令牌
        String token = request.getHeader("token");
        Map<String,Object> map = new HashMap<>();
        try {
            // 验证令牌
            JWTUtil.verifyToekn(token);
            map.put("state",true);
            map.put("msg","请求成功");
            return true; //放行请求
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "无效签名");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", "token 失效");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg","两次算法不一致");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "token 无效");
        }
        map.put("state",false);// 设置状态
        // 将 map 转为 JSON，并传给前端  jackson
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");;
        response.getWriter().print(json);
        return false;
    }
}
