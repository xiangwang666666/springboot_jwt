package com.edu.newer;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @author XW
 * @create 2022-02-21 20:07
 */
public class Test {
   @org.junit.Test
    public  void getJWT(){
       HashMap<String, Object> map = new HashMap<>();
     Calendar calendar=Calendar.getInstance();
     calendar.add(Calendar.SECOND, 300);
       String token = JWT.create()
//               .withHeader(map)//header
               .withClaim("userId", 21)
               .withClaim("username", "xw")//payload
               .withExpiresAt(calendar.getTime())//令牌过期时间
               .sign(Algorithm.HMAC256("!q@e#r$%t%&"));//签名
       System.out.println(token);
   }
   @org.junit.Test
   public void test(){
       JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!q@e#r$%t%&")).build();
       DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDU0NDc3OTcsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoieHcifQ.cmRQWv9FkiVKAWH3ZbC0ckm_Oi1WtHLJqS9-h_h0TIg");
       System.out.println(verify.getClaim("userId").asInt());
       System.out.println(verify.getClaim("username").asString());
       System.out.println(verify.getExpiresAt());
   }
}
