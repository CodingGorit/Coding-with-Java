package cn.gorit.controller;

import cn.gorit.entity.Book;
import cn.gorit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/getmaxbook")
    @ResponseBody
    public Book getMaxIdBook() {
        return bookService.getBookByMaxId();
    }

    @RequestMapping("/getmixbook")
    @ResponseBody
    public Book getMinIdBook() {
        return bookService.getBookByMinId();
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(ModelMap mm) {
        // 该方法中，findAll 接口中，首先通过调用 PageRequest 中的 of 方法构造 PageRequest 对象。 of 方法接收两个参数
        // 第一个参数是页数，从0开始计数，第二个参数是每页显示的页数
        Map<String,Object> map = new HashMap<String, Object>();
        PageRequest pageable = PageRequest.of(0,5);
        Page<Book> page = bookService.getBookByPage(pageable);
        System.out.println("总页数：" +page.getTotalPages());
        System.out.println("总记录数："+page.getTotalElements());
        System.out.println("查询结果："+page.getContent());
        System.out.println("当前页数："+(page.getNumber()+1));
        System.out.println("当前页记录数："+page.getNumberOfElements());
        System.out.println("每页记录数："+page.getSize());

        map.put("总页数：" ,page.getTotalPages());
        map.put("查询结果：",page.getContent());
        map.put("当前页数",(page.getNumber()+1));

        return map;
    }



    @RequestMapping("/search")
    public void search() {
        List<Book> bs1 = bookService.getBookByIdAndAuthor("鲁迅",7);
        List<Book> bs2 = bookService.getBooksByAuthorStartingWith("吴");
        Book b = bookService.getBookByMinId();
        System.out.println(bs1.toString());
        System.out.println(bs2.toString());
        System.out.println(b.toString());
    }

    // 进入 update 页面
    @RequestMapping(value = "/update/book",method = RequestMethod.GET)
    public String updatebook(@RequestParam("id") Integer id,ModelMap map) {
        map.addAttribute("book",bookService.getBookById(id));
        return "update";
    }

    @RequestMapping(value = "/delete/book",method = RequestMethod.GET)
    public String deleteBook(@RequestParam("id") Integer id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/update/book/{id}",method = RequestMethod.POST)
    public String update(@PathVariable("id") Integer id, @ModelAttribute Book book) {
        book.setId(id);
        System.out.println(book.toString());
        bookService.updateBook(book);
        return "redirect:/";
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addbook() {
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST )
    public String save(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/book",method = RequestMethod.GET)
    public String queryAllBokks(ModelMap map) {
        List<Book> list = bookService.getBooks();
        map.addAttribute("list",list);
        return "show";
    }

 }
