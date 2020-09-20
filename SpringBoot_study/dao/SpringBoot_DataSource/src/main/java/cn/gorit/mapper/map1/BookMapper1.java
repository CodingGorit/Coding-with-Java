package cn.gorit.mapper.map1;

import cn.gorit.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper1 {

    List<Book> getAllBooks();
}
