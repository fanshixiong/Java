package com.frans.dao.goods;

import com.frans.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    public List<Goods> getGoodsList();
}
