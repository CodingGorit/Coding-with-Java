import cn.gorit.entity.Student;
import cn.gorit.entity.User;
import cn.gorit.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

public class TestUser {

    @Test
    public void test() {
        Session session =  HibernateUtils.getSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> list = criteria.list();
        for (User u:list) {
            System.out.println(u.toString());
            if (u.getUsername().equals("admin") && u.getPassword().equals("123456")) {
                System.out.println("ok");
            }
        }
    }

    @Test
    public void test1() {
        Session session =  HibernateUtils.getSession();
        Criteria criteria = session.createCriteria(Student.class);
        List<Student> list = criteria.list();
        for (Student stu: list) {
            System.out.println(stu.toString());
        }
    }

    @Test
    public void TestDelte() {
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();
        Student stu = (Student) session.createQuery("from student where stuId = '9999'");
        session.delete(stu);
        t.commit();
        session.close();
    }
}
