package com.edu.newer.controller;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.edu.newer.entity.User;
import com.edu.newer.service.UserService;
import com.edu.newer.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XW
 * @create 2022-02-21 21:51
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("user/login")
    public  Map<String,Object> login(User user){
        log.info("用户名:[{}]",user.getName());
        log.info("密码:[{}]",user.getPassword());
        Map<String, Object> map=new HashMap<>();
        try {
            User userDB = userService.login(user);
            //生成JWT令牌
            Map<String, String> payload=new HashMap<>();
            payload.put("userId",userDB.getId());

            payload.put("name",userDB.getName());
            String token = JWTUtils.getToken(payload);
            map.put("state", true);
            map.put("msg", "认证成功");
            map.put("token",token);//响应token
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", "认证失败");
        }
        return  map;
    }
    @PostMapping("/user/test")
    public  Map<String, Object> test(HttpServletRequest request){
        Map<String, Object> map=new HashMap<>();
        //处理自己的业务
        String token = request.getHeader("token");
        DecodedJWT verify = JWTUtils.verify(token);
        String name = verify.getClaim("name").asString();
        String id = verify.getClaim("userId").asString();
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        map.put("state",true);
            map.put("msg","请求成功");
            return map;



    }
}
