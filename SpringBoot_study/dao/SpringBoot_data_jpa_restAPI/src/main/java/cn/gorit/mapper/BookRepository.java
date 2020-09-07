package cn.gorit.mapper;

import cn.gorit.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
//@RepositoryRestResource(path = "bs",collectionResourceRel = "bs", itemResourceRel = "b")
@RepositoryRestResource(exported = true)
public interface BookRepository extends JpaRepository<Book,Integer> {

    /**
     * 自定义查询只需要在该类中定义相关的查询方法即可，定义好的方法可以不用添加 @RestResource 注解，
     * 默认路径就是 方法名，以第一个方法为例：
     *      不加注解：路径为： http://localhost/books/search/findByAuthorContains?author=鲁迅
     *      添加注解：路径为：http://localhost/books/search/author?author=鲁迅
     *
     *      用户可以直接访问:http://localhost/books/search 路径查看哪些暴露出来的方法
     * */
    @RestResource(path = "author", rel = "author")
    List<Book> findByAuthorContains(@Param("author") String author);

    @RestResource(path = "name",rel = "name")
    Book findByNameEquals(@Param("name") String name);
}
