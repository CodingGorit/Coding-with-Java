package cn.gorit.test_crud;

import cn.gorit.entity.AccountEntity;
import cn.gorit.entity.DbUserEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.sql.ResultSet;
import java.util.List;

public class TestQuery {
    public static void main(String[] args) {
        // hibernate 配置对象
        Configuration cf = new Configuration().configure();
        // 通过配置对象建立 session 的工厂
        SessionFactory sf = cf.buildSessionFactory();
        // 通过 session 的工厂得到 session
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(DbUserEntity.class);
        List<DbUserEntity> list = criteria.list();
        for (DbUserEntity ls: list) {
            System.out.println(ls.getId()+" "+ls.getUsername()+" "+ls.getPassword()+" "+ls.getStatus());
        }
        // 关闭资源
        session.close();
    }
}
