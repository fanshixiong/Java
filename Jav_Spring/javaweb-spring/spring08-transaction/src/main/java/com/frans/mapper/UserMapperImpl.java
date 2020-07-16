package com.frans.mapper;

import com.frans.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{

    //原来我们的所有操作都是用SqlSession来执行， 现在使用SQLSessionTemplate
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<User> selectUser() {
        sqlSessionTemplate.getMapper(UserMapper.class).addUser(new User(1991, 1, 1, 1));
        sqlSessionTemplate.getMapper(UserMapper.class).delete(22);
        return sqlSessionTemplate.getMapper(UserMapper.class).selectUser();
    }

    @Override
    public int addUser(User user) {
        return sqlSessionTemplate.getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int delete(int id) {
        return sqlSessionTemplate.getMapper(UserMapper.class).delete(id);
    }
}
