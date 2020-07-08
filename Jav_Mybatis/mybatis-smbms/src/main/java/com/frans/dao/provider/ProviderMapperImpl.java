package com.frans.dao.provider;

import com.frans.pojo.Provider;
import com.frans.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProviderMapperImpl implements ProviderMapper{
    @Override
    public int add(Provider provider) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        int add = mapper.add(provider);
        sqlSession.commit();
        sqlSession.close();
        return add;
    }

    @Override
    public List<Provider> getProviderList(String proName, String proCode) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        List<Provider> providerList = mapper.getProviderList(proName, proCode);
        sqlSession.close();
        return providerList;
    }

    @Override
    public int deleteProviderById(String delId) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        int i = mapper.deleteProviderById(delId);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public Provider getProviderById(String id) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        Provider providerById = mapper.getProviderById(id);
        sqlSession.close();
        return providerById;
    }

    @Override
    public int modify(Provider provider) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        int modify = mapper.modify(provider);
        sqlSession.commit();
        sqlSession.close();
        return modify;
    }
}
