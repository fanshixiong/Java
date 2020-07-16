package com.frans.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userPermitted;
    private String userEmail;
    private String userAddress;
    private String userCallPhone;
}
