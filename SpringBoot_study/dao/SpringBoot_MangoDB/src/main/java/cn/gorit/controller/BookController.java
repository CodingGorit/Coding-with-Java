package cn.gorit.controller;

import cn.gorit.dao.BookDao;
import cn.gorit.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname BookController
 * @Description TODO
 * @Date 2020/11/9 21:51
 * @Created by CodingGorit
 * @Version 1.0
 */
@RestController
public class BookController {

    // 实用内齿提供的 baseMongo
    @Autowired
    BookDao dao;

    // 实用 内置的template
    @Autowired
    MongoTemplate template;

    @GetMapping("/test1")
    public void test1() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"年华","ls"));
        books.add(new Book(2,"楼记","ls"));
        dao.insert(books);
        List<Book> b1 = dao.findAllByAuthor("ls");
        System.out.println(b1.toString());
        System.out.println(dao.findByNameEquals("楼记"));
    }

    @GetMapping("/test2")
    public void test2() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(3,"围城","钱钟书"));
        books.add(new Book(4,"宋诗选注","钱钟书"));

        template.insertAll(books);
        List<Book> list = template.findAll(Book.class);
        System.out.println(list);
        Book book = template.findById(3,Book.class);
        System.out.println(book);
    }
}
