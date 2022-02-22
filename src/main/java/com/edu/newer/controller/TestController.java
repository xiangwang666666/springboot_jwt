package com.edu.newer.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author XW
 * @create 2022-02-21 19:54
 */
@RestController
public class TestController {

    @GetMapping("/test/test")
    public  String test(String username, HttpServletRequest request){
        request.getSession().setAttribute("username",username);

        return  "login-ok";
    }
}
