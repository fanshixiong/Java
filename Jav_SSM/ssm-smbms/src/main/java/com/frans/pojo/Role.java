package com.frans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private long id;
    private String roleCode;
    private String roleName;
    private long createdBy;
    private Date creationDate;
    private long modifyBy;
    private Date modifyDate;
}