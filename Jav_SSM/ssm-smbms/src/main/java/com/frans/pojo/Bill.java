package com.frans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private long id;
    private String billCode;
    private String productName;
    private String productDesc;
    private String productUnit;
    private String productCount;
    private String totalPrice;
    private int isPayment;
    private long createdBy;
    private Date creationDate;
    private long modifyBy;
    private Date modifyDate;
    private Provider provider;
    private int providerId;
}