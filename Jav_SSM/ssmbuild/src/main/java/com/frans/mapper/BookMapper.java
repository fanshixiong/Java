package com.frans.mapper;

import com.frans.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookMapper {

    //����һ��Book
    int addBook(Books book);

    //����idɾ��һ��Book
    int deleteBookById(@Param("bookID") int id);

    //����Book
    int updateBook(Books books);

    //����id��ѯ,����һ��Book
    Books queryBookById(@Param("bookID") int id);

    //��ѯȫ��Book,����list����
    List<Books> queryAllBook();

    //�������Ʋ�ѯ�鼮
    List<Books> queryBookByName(@Param("bookName") String bookName);
}
