package com.frans.test;

import com.frans.dao.BlogMapper;
import com.frans.pojo.Blog;
import com.frans.utils.IDUtils;
import com.frans.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void getTeachers(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getID()); ;
        blog.setTitle("Mybatis"); ;
        blog.setAuthor("frans");
        blog.setCreateTime(new Date());
        blog.setViews (9999);

        mapper.addBlog(blog) ;
        blog.setId(IDUtils.getID()); ;
        blog.setTitle("Java"); ;
        mapper.addBlog(blog) ;
        blog.setId(IDUtils.getID()); ;
        blog.setTitle("SPring"); ;
        mapper.addBlog(blog) ;
        blog.setId(IDUtils.getID()); ;
        blog.setTitle("Swing"); ;
        mapper.addBlog(blog) ;

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("title", "Java");
        hashMap.put("author", "frans");
        List<Blog> blogs = mapper.queryBlogIF(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        hashMap.put("title", "Java");
        hashMap.put("author", "frans");
        hashMap.put("views", 9999);
        List<Blog> blogs = mapper.queryBlogChoose(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        //hashMap.put("title", "Java2");
        hashMap.put("author", "frans2");
        hashMap.put("views", 9999);
        mapper.updateBlog(hashMap);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap hashMap = new HashMap();
        ArrayList<Integer> lists = new ArrayList<Integer>();
        lists.add(9999);
        lists.add(1111);
        lists.add(2222);
        lists.add(3333);
        hashMap.put("lists", lists);
        List<Blog> blogs = mapper.queryBlogForeach(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

}
