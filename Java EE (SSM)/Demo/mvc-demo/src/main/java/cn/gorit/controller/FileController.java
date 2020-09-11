package cn.gorit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping(value = "/user/fileupload",method = RequestMethod.POST)
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传。。。");

        // 使用 fileupload 完成文件上传
        String path =  request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }
        // 上传文件项
        // 获取到上传文件的名称
        String fileName = upload.getOriginalFilename();
        // 把每一个文件名称设置唯一值， uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        fileName = uuid +"_"+ fileName;

        // 完成文件上传
        upload.transferTo(new File(path,fileName));
        return "index";
    }

}
