package com.frans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int goodsId;
    private String goodsName;
    private String goodsType;
    private Double goodsPrice;
    private String goodsDate;
    private Integer goodsAmount;
    private String goodsImgUrl;
    private String goodsIntroduction;
}
