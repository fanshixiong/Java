package com.frans.dao.bill;

import com.frans.pojo.Bill;
import com.frans.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class BillMapperImpl implements BillMapper{
    @Override
    public int add(Bill bill) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int add = mapper.add(bill);
        sqlSession.commit();
        sqlSession.close();
        return add;
    }

    @Override
    public List<Bill> getBillList(Bill bill) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> billList = mapper.getBillList(bill);
        sqlSession.close();
        return billList;
    }

    @Test
    public void getBill() throws Exception {
        Bill billById = getBillById("2");
        billById.setProviderId(0);
        billById.setProductName(null);
        billById.setIsPayment(0);
        List<Bill> billList = getBillList(billById);
        for (Bill bill : billList) {
            System.out.println(bill);
        }
    }

    @Override
    public int deleteBillById(String delId) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int i = mapper.deleteBillById(delId);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public Bill getBillById(String id) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Bill billById = mapper.getBillById(id);
        sqlSession.close();
        return billById;
    }


    @Override
    public int modify(Bill bill) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int modify = mapper.modify(bill);
        sqlSession.commit();
        sqlSession.close();
        return modify;
    }

    @Override
    public int getBillCountByProviderId(String providerId) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int billCountByProviderId = mapper.getBillCountByProviderId(providerId);
        sqlSession.close();
        return billCountByProviderId;
    }
}
