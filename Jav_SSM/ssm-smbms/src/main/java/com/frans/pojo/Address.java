package com.frans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private long id;
    private String contact;
    private String addressDesc;
    private String postCode;
    private String tel;
    private long createdBy;
    private Date creationDate;
    private long modifyBy;
    private Date modifyDate;
    private long userId;
}