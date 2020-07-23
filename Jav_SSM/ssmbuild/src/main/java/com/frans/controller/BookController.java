package com.frans.controller;

import com.frans.pojo.Books;
import com.frans.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍并返回到一个前端页面allBook
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String add(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("Add Books======================>");
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }


    //跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        System.out.println("bookid============>" + id);
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book", books);
        return "updateBook";
    }
    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println("updateBook======>" + book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/del/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id) {
        System.out.println("updateBook======>" + id);
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model){
        List<Books> books = bookService.queryBookByName(queryBookName);
        model.addAttribute("list", books);
        return "allBook";
    }

}
