package cn.gorit.dao.Impl;

import cn.gorit.dao.UserDao;
import cn.gorit.entity.User;
import cn.gorit.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public int selectUserByNameAndPwd(String username, String password) {
        Session session =  HibernateUtils.getSession();
        Query query = session.createQuery("from User u where u.username = :a and u.password = :b").setString("a",username).setString("b",password);
        User user = (User)query.uniqueResult();
        if (user!= null) {
            System.out.println("ok");
            return 1;
        }
        return 0;
    }
}
