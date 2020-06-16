package cn.gorit.test_crud;

import cn.gorit.entity.DbUserEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestUpdate {
    public static void main(String[] args) {
        // hibernate 配置对象
        Configuration cf = new Configuration().configure();
        // 通过配置对象建立 session 的工厂
        SessionFactory sf = cf.buildSessionFactory();
        // 通过 session 的工厂得到 session
        Session session = sf.openSession();
        DbUserEntity db = new DbUserEntity();
        db.setId(25);
        db.setUsername("zhangsan");
        db.setPassword("zhangsan");
        db.setStatus(new Byte("3"));
        // 开启事物
        Transaction t = session.beginTransaction();
        session.update(db);
        t.commit();
        // 关闭资源
        session.close();
    }
}
