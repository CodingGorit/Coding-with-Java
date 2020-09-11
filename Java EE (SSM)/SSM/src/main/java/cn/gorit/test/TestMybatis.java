package cn.gorit.test;

import cn.gorit.dao.AccountDao;
import cn.gorit.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run() {
        // 加载配置文件
        try {
            InputStream in = Resources.getResourceAsStream("mybatis.xml");
            // 创建 SqlSessionFactory 对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            // 创建 SqlSession 独享
            SqlSession session = factory.openSession();
            // 获取到代理对象
            AccountDao dao =session.getMapper(AccountDao.class);
            // 查询所有数据
            List<Account> list = dao.findAll();
            for (Account account:list) {
                System.out.println(account);
            }
            // 关闭资源
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 保存
    @Test
    public void run2() {
        // 加载配置文件
        try {
            InputStream in = Resources.getResourceAsStream("mybatis.xml");
            // 创建 SqlSessionFactory 对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            // 创建 SqlSession 独享
            SqlSession session = factory.openSession();
            // 获取到代理对象
            AccountDao dao =session.getMapper(AccountDao.class);
            // 添加数据

//            int res = dao.saveAccount(new Account("coco",500));
            // 提交事物
            session.commit();
//            if (res > 0) {
//                System.out.println("添加成功");
//            }
            // 关闭资源
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
