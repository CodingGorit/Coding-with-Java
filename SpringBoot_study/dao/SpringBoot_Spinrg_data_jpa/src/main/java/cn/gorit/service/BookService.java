package cn.gorit.service;

import cn.gorit.dao.BookDao;
import cn.gorit.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookDao bd;

    // 添加书籍
    public void addBook(Book book) {
        bd.save(book);
    }

    // 分页查询数据
    public Page<Book> getBookByPage(Pageable pageable) {
        return bd.findAll(pageable);
    }

    // 根据作者名称查询书籍
    public List<Book> getBooksByAuthorStartingWith(String author) {
        return bd.getBooksByAuthorStartingWith(author);
    }

    // 查询比数据加个大于等于的书籍
    public List<Book> getBooksByPriceGreaterThan(Double price) {
        return bd.getBooksByPriceGreaterThan(price);
    }

    public Book getBookByMaxId() {
        return bd.getMaxIdBook();
    }

    public Book getBookByMinId() {
        return bd.getMinIdBook();
    }

    public List<Book> getBookByIdAndAuthor(String author, Integer id) {
        return bd.getBooksByIdAndAuthor(author, id);
    }

    public List<Book> getBooksByIdAndName(String name, Integer id) {
        return bd.getBooksByIdAndName(name, id);
    }
}
