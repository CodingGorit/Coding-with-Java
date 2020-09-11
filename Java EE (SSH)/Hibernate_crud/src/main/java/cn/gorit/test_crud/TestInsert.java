package cn.gorit.test_crud;

import cn.gorit.entity.AccountEntity;
import cn.gorit.entity.DbUserEntity;
import cn.gorit.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// hibernate 原始方式加载
public class TestInsert {
    public static void main(String[] args) {
        // hibernate 配置对象
        Configuration cf = new Configuration().configure();
        // 通过配置对象建立 session 的工厂
        SessionFactory sf = cf.buildSessionFactory();
        // 通过 session 的工厂得到 session
        Session session = sf.openSession();
//        DbUserEntity db = new DbUserEntity();
//        db.setId(25);
//        db.setUsername("zhangsan");
//        db.setPassword("lisi");
//        db.setStatus(new Byte("3"));
        AccountEntity account = new AccountEntity(12,"张三",1232.4);
        // hibernate 的事物不是隐式事物，需要手动提交
        // 开启事物
        Transaction t = session.beginTransaction();
        // 保存
        session.save(account);
        // 提交事物
        t.commit();
        // 关闭资源
        session.close();
    }
}
