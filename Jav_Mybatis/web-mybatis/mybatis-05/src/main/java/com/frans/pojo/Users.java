package com.frans.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("users1")
@Data
@AllArgsConstructor
public class Users {
    private int id;
    private int name;
    private int password;
    private int address;
}
