package com.owly.delivery.dao;

import com.owly.delivery.entity.Authorities;
import com.owly.delivery.entity.User;
import com.owly.delivery.entity.Authorities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(User user) throws Exception {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmail(user.getEmail());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(user);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            throw new Exception(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public User getUser(String email) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
}
