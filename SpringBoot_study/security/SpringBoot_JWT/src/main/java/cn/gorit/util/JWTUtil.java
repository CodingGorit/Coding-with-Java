package cn.gorit.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;


import java.util.Calendar;
import java.util.Map;

public class JWTUtil {

    private static final String SINGNATURE = "1Q2w3e43ken!2345dd";

    /**
     * 生成 token  header.payload.sing
     * @param map 传入 payload
     * @return 返回加密后的 token
     */
    public static String getToken(Map<String,String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7); // 默认七天过期

        // 创建 JWT builder
        JWTCreator.Builder builder = JWT.create();
//        builder.withHeader("");
        // payload
        map.forEach((k,v)-> {
            builder.withClaim(k,v);
        });

        // 指定过期时间, 并返回加密后的签名
        return builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SINGNATURE));
    }

    /**
     * 验证 token，有异常会抛出异常，没有异常就返回 Token
     * @param token
     */
    public static DecodedJWT verifyToekn(String token) {
        return JWT.require(Algorithm.HMAC256(SINGNATURE)).build().verify(token);
    }

    /**
     * 获取 token 信息的方法
     */
//    public static DecodedJWT getTokenInfo(String token) {
//        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SINGNATURE)).build().verify(token));
//        return verify;
//    }

}
