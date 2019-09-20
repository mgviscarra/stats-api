package com.mgvr.stats.api.dao;

import com.mgvr.stats.api.constants.UsersDbFields;
import com.mgvr.stats.api.model.user.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Transactional
public class UserDao {
    @Autowired
    private SessionFactory factory;

    public void updateUserStats(String realName, int nroKudos){
        User user = getUserByRealName(realName);
        user.setNroKudos(nroKudos);
        getSession().update(user);
    }

    private Session getSession() {
        Session session = factory.getCurrentSession();
        if (session == null) {
            session = factory.openSession();
        }
        return session;
    }

    private User getUserByRealName(String realName){
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(builder.equal(root.get(UsersDbFields.REAL_NAME),realName));
        Query<User> userQuery = getSession().createQuery(criteria);
        User user;
        try{
            user = userQuery.getSingleResult();
        }
        catch (Exception e){
            return null;
        }
        return user;
    }

}
