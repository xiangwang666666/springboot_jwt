package com.edu.newer.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XW
 * @create 2022-02-21 20:52
 */
public class JWTUtils {
 private  static final  String SING="aqed!$@%$12334adk";
    //生成token header.Paylod.signature
public  static String getToken(Map<String, String> map){
    Calendar calendar=Calendar.getInstance();
    calendar.add(Calendar.DATE, 7);
    JWTCreator.Builder builder = JWT.create();
    //payload
    map.forEach((k,v)-> {
        builder.withClaim(k,v);
    });
    //sign
    String token= builder.withExpiresAt(calendar.getTime())
            .sign(Algorithm.HMAC256(SING));
    return token;
}
 //token验证
  public  static DecodedJWT  verify(String token) {
      return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
  }

  //获取token信息
//    public  static  DecodedJWT  getTokenInfo(String token){
//        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
//         return  verify;
//    }
}
