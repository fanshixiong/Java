package com.frans.service;

import com.frans.pojo.Books;

import java.util.List;

//BookService:������Ҫȥʵ��,����dao��
public interface BookService {
    //����һ��Book
    int addBook(Books book);
    //����idɾ��һ��Book
    int deleteBookById(int id);
    //����Book
    int updateBook(Books books);
    //����id��ѯ,����һ��Book
    Books queryBookById(int id);
    //��ѯȫ��Book,����list����
    List<Books> queryAllBook();
    //�������Ʋ�ѯ
    List<Books> queryBookByName(String bookName);
}