package cn.gorit.dao;

import cn.gorit.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 自定义的 BookDao 继承 JpaRepository，JpaRepository中提供了一些基本的数据库方法，
 * 有基本的增删改查，分页查询，排序查询
 *
 * 在 Spring Data Jpa 中，只要方法的定义符合既定规范，Spring Data 就能分析出爱发者的意图，就能避免开发者定义 SQL
 * nativeQuery = true 表示使用原生的 SQL 查询
 *
 * */
public interface BookDao extends JpaRepository<Book,Integer> {

    @Query(value="select id,author,book_name,price from t_book",nativeQuery = true)
    List<Book> getBooks();

    List<Book> getBooksByAuthorStartingWith(String author);

    List<Book> getBooksByPriceGreaterThan(Double price);

    @Query(value = "select * from t_book where id = (select max(id) from t_book )", nativeQuery = true)
    Book getMaxIdBook();

    @Query(value = "select * from t_book where id = (select min(id) from t_book )", nativeQuery = true)
    Book getMinIdBook();


    /**
     *      JPQL 查询
     *      根据 id 和 author 查询，这里使用默认的 JPQL，JPQL 是一种面向对象的表达式语言。可以将 SQL 语法和简单查询语义绑定在一起
     *      这种语句是可以被编译成主流数据库的 SQL 语句，这里和 HQL 语句比较相似
     *      下面使用 :id, :author 实现了数据的绑定，这里的字段并非数据库中的字段
     */


    @Query(value = "select b from t_book b where b.id>:id and b.author=:author")
    List<Book> getBooksByIdAndAuthor(@Param("author") String author, @Param("id") Integer id);

    @Query("select b from t_book b where b.id<?2 and b.name like %?1%")
    List<Book> getBooksByIdAndName(String name, Integer id);

    // 如果 BookDao 中的方法涉及修改操作，需要添加 @Modifying 注解添加事物

    @Transactional
    @Modifying
    @Query(value ="update t_book set author = :#{#book.author},book_name = :#{#book.name}, price = :#{#book.price} where id = :#{#book.id}")
    void updateBook(Book book);
}
