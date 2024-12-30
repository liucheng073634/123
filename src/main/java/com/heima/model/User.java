package com.heima.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    // 其他用户信息字段...
} 