package cn.gorit.action;


import org.apache.struts2.ServletActionContext;

import java.io.*;

public class UpLoadAction {
    private File file;//得到上传的文件对象
    private String fileFileName;//上传文件的名称
    private String fileContentType;//上传文件的类型

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    // 文件流，将一个文件复制到另一个地方进行保存
    public String execute() throws IOException {
        //获取目标文件夹的位置来确定新文件的路径
        String str=ServletActionContext.getServletContext().getRealPath("/upload");
        File newfile=new File(str, fileFileName);
        if(!newfile.exists()){
            newfile.createNewFile();
        }
        //获取输入流和输出流
        FileInputStream fis=new FileInputStream(file);//上传文件的输入流
        FileOutputStream fos=new FileOutputStream(newfile);//新文件的输出流
        int data=0;
        while((data=fis.read())!=-1){
            fos.write(data);
        }
        fos.close();fis.close();
        return "success";
    }
}
