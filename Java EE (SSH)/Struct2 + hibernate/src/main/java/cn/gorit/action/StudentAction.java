package cn.gorit.action;

import cn.gorit.dao.Impl.StudentDaoImpl;
import cn.gorit.dao.StudentDao;
import cn.gorit.entity.ClasszEntity;
import cn.gorit.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class StudentAction {
    StudentDao dao = new StudentDaoImpl();
    private Student stu;

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public String getAllStudent () {
        ActionContext ac = ActionContext.getContext(); // struct2 构造缘生意的 session
        Map<String, Object> session = ac.getSession();
        List<Student> list = dao.queryStudents();
        session.put("list",list);
        return "success";
    }

    public String deleteStudent () {
        System.out.println("删除学生信息");
//        System.out.println(u.getId());
        HttpServletRequest request= ServletActionContext.getRequest();
        String stuId = request.getParameter("stuID");
        System.out.println(stuId);
        int res = dao.deleteStudent(stuId);
        return "success";
    }

    public String addStudent() {
        System.out.println("添加学生");
        System.out.println(stu.toString());
        String Grade = stu.getClassz().substring(0,2);
        String Clazz = stu.getClassz().substring(2);
        System.out.println(Grade + "\n" + Clazz);
        // 空值处理
        if (stu.getStuId().equals("") || stu.getStuName().equals("") || stu.getStuAge() == 0 || stu.getClassz().equals("")) {
            return "error";
        }
        int res = dao.addStudent(stu,Grade,Clazz);
        if (res > 0)
            return "success";
        else
            return  "error";
    }

    public String updateStudent() {
        HttpServletRequest request= ServletActionContext.getRequest();
        String stuId = request.getParameter("stuId");
        stu.setStuId(stuId);
        System.out.println(stu.toString());
        // 设置 年级 和 班级
        String Grade = stu.getClassz().substring(0,2);
        String Clazz = stu.getClassz().substring(2);

        int res = dao.updateStudent(stu,Grade,Clazz);
        return "success";
    }
}
