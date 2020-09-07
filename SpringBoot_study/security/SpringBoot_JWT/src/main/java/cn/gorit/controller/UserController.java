package cn.gorit.controller;

import cn.gorit.entity.User;
import cn.gorit.service.UserService;
import cn.gorit.util.JWTUtil;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/user/login")
    public Map<String,Object> login(User user, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<>();
        try {
           User userDB = userService.login(user);
            //生成 JWT 令牌
            Map<String,String> payload = new HashMap<>();
            payload.put("username",user.getUsername());
            payload.put("userId",String.valueOf(userDB.getId()));
            String token = JWTUtil.getToken(payload);

            map.put("state",true);
            map.put("msg","登录成功~");
            map.put("code",200);
            map.put("token",token); // 响应 token 并保存到客户端， 自动保存到请求头中
//            response.setHeader("token",token);
        } catch (Exception e) {
            map.put("state",false);
            map.put("msg","认证失败");
        }
        return map;
    }

    @PostMapping("/user/test")
    public Map<String,Object> test(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        String token = request.getHeader("token");
        DecodedJWT verify = JWTUtil.verifyToekn(token);
        System.out.println(verify.getClaim("userId").asString());
        System.out.println(verify.getClaim("username").asString());
        // 处理自己的业务逻辑
        map.put("state",true);
        map.put("msg","请求成功");
        return map;
    }
}
