package cn.gorit.action;

import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DownloadAction {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String execute() { // 没有作用
        return "success";
    }

    // 下载文件
    public InputStream getInputStream() throws FileNotFoundException {
        System.out.println("我进来了");
        String str = ServletActionContext.getServletContext().getRealPath("/upload");
        File f = new File(str, fileName);
        FileInputStream fis = new FileInputStream(f);
        return fis;
    }

}
