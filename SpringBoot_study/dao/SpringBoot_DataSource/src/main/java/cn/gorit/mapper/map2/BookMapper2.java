package cn.gorit.mapper.map2;

import cn.gorit.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper2 {

    List<Book> getAllBooks();
}
