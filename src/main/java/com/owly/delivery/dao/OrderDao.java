package com.owly.delivery.dao;

import com.owly.delivery.entity.Authorities;
import com.owly.delivery.entity.Orders;
import com.owly.delivery.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Orders order) {
//        Authorities authorities = new Authorities();
//        authorities.setAuthorities("ROLE_USER");
//        authorities.setEmail(user.getEmail());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    // get order by create Time, if b
//    public Orders getOrderByCreateTime (Timestamp createTime) {
//        Orders order = null;
//        try (Session session = sessionFactory.openSession()) {
//            Criteria criteria = session.createCriteria(Orders.class);
//            order = (Orders) criteria.add(Restrictions.eq("", createTime)).uniqueResult();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return order;
//    }



}