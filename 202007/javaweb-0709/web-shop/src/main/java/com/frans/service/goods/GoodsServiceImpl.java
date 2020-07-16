package com.frans.service.goods;

import com.frans.dao.goods.GoodsMapper;
import com.frans.pojo.Goods;
import com.frans.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class GoodsServiceImpl implements GoodsService{
    @Override
    public List<Goods> getGoodsList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goodsListList = mapper.getGoodsList();

        return goodsListList;
    }
    @Test
    public void test(){
        List<Goods> lst = getGoodsList();
        for (Goods goods : lst) {
            System.out.println(goods);
        }
    }
}
