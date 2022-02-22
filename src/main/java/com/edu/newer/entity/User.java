package com.edu.newer.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author XW
 * @create 2022-02-21 21:38
 */
@Data
@Accessors(chain = true)
public class User {
    private  String id;
    private String name;
    private String password;

}
