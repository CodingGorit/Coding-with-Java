package cn.gorit.test_crud;

import cn.gorit.entity.AccountEntity;
import cn.gorit.entity.DbUserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDelete {
    public static void main(String[] args) {
        // hibernate 配置对象
        Configuration cf = new Configuration().configure();
        // 通过配置对象建立 session 的工厂
        SessionFactory sf = cf.buildSessionFactory();
        // 通过 session 的工厂得到 session
        Session session = sf.openSession();
        // 开启事物
        Transaction t = session.beginTransaction();
        // 删除
        session.delete(new AccountEntity(12,"张三",123.4));
        session.delete("");
        // 提交事物
        t.commit();
        // 关闭资源
        session.close();
    }
}
