package cn.gorit.controller;

import cn.gorit.pojo.Content;
import cn.gorit.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Classname ContentController
 * @Description TODO
 * @Date 2020/10/22 18:45
 * @Created by CodingGorit
 * @Version 1.0
 */
@RestController
public class ContentController {

    @Autowired
    private ContentService service;

    /**
     * 将数据添加到 ES 中
     * @param keyword
     * @return
     * @throws Exception
     */
    @GetMapping("/parse/{keyword}")
    public Boolean pares(@PathVariable("keyword")  String keyword) throws Exception {
        return service.parseContent(keyword);
    }

    /**
     * 查询 ES 的数据
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     * @throws IOException
     */
    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String,Object>> search(@PathVariable("keyword") String keyword,@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) throws IOException {
        if (pageNo == 0) {
            pageNo = 1;
        }
        return service.searchPage(keyword, pageNo, pageSize);
    }
}
