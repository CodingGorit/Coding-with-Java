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
        Criteria criteria = session.createCriteria(User.class);
        List<User> list = criteria.list();
        for (User u:list) {
            System.out.println(u.toString());
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("ok");
                return 1;
            }
        }
        return 0;
    }
}
