package com.bear.boot.template.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-21 20:19
 **/
public class JwtDemo {
    /**
     * 私钥，生成签名要用，一般可以从本地配置中读取
     */
    private final static String SECRET = "123456789";

    public static String createJwtToken() {
        Map<String, Object> header = new HashMap<>(4);
        //Header
        header.put("alg","HS256");
        header.put("typ","JWT");

        //Payload
        Map<String, Object> claims = new HashMap<>(8);
        //标准中注册的声明
        claims.put("iss","bear");
        //
        claims.put("id","980529");
        claims.put("userName","admin");

        //
        return Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                //设置过期时间：1小时
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .setSubject("Tom")
                //通过签名算法和密钥生成签名
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public static Claims getClaimsFromJwt(String jwt) {
        //Claims claims = null;

        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwt).getBody();


    }

    public static void main(String[] args) {
        String jwtToken = createJwtToken();
        System.out.println("JWT Token" + jwtToken);
        System.out.println("++++++++++++++++++++++");

        Claims claims = getClaimsFromJwt(jwtToken);
        System.out.println("claims: " + claims);
    }
}
