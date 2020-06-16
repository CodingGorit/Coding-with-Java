package dao.Impl;

import dao.UserDao;
import entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

// 使用 Spring 来接管持久层的所有操作
@Repository
public class UserDaoImpl implements UserDao {

    // 使用 Hibernate 提供的模板
    @Autowired
    @Resource
    private HibernateTemplate hibernateTemplate;

    // 生成对应的 get 和 set 方法
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        // 登录的逻辑不算难，就是使用 sql 语句查询，username 和 password 两个字段是否存在即可,我们使用的是 hibernate 框架，所以要写 hql 语句
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Query q = session.createQuery("from User u where u.username = ? and u.password = ?");
        q.setParameter(0,username);
        q.setParameter(1,password);
        User u = (User) q.uniqueResult();
        return u;
    }
}
