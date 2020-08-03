package com.frans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String userCode;
    private String userName;
    private String userPassword;
    private int gender;
    private String userGender;
    private Date birthday;
    private int age;
    private String phone;
    private String address;
    private int userRole;
    private long createdBy;
    private Date creationDate;
    private long modifyBy;
    private Date modifyDate;
    private Role role;
}