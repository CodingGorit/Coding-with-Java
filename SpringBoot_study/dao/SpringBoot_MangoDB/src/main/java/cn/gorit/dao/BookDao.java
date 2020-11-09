package cn.gorit.dao;

import cn.gorit.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Classname BookDao
 * @Description TODO
 * @Date 2020/11/9 21:48
 * @Created by CodingGorit
 * @Version 1.0
 */
public interface BookDao extends MongoRepository<Book,Integer> {
    List<Book> findAllByAuthor(String author);

    Book findByNameEquals(String name);
}
