package cn.gorit.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;

//@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,3600); // 一个小时后过期
        HashMap<String,Object> map = new HashMap<>();

        // 这里 Chain 可以放多个，也可以放数组
        String token = JWT.create()
                .withHeader(map) //header 可省略
                .withClaim("name",21)//payload
                .withClaim("username","John")
                .withExpiresAt(instance.getTime())// 令牌的过期时间
                .sign(Algorithm.HMAC256("saws123daweda"));// 签名
        System.out.println(token);
    }

    // 验证对象
    @Test
    public void checkJWT() {
        // 创建验证对象
       JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("saws123daweda")).build();
        // 得到 解码的 JWT
       DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoyMSwiZXhwIjoxNTk3MjkzODk0LCJ1c2VybmFtZSI6IkpvaG4ifQ.eIKgUXUQiHqLwkbI-SK5SxzGAcE5wKP_hho7vtMtu_4");
       System.out.println(verify.getHeader());
       System.out.println(verify.getClaim("name").asInt());
       System.out.println(verify.getClaim("username").asString());
       System.out.println(verify.getClaims());  // 只能得到后者的 Clain
       System.out.println(verify.getPayload());
       System.out.println(verify.getSignature());
    }

}
