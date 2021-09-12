package com.owly.delivery.dao;

import com.owly.delivery.entity.Tracking;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jvnet.fastinfoset.sax.RestrictedAlphabetContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TrackingDao {
    @Autowired
    SessionFactory sessionFactory;

    public ArrayList<Tracking> getTrackingByOrderID(int orderID){
        ArrayList<Tracking> trackingList = null;
        try (Session session = sessionFactory.openSession()){
            Criteria criteria = session.createCriteria(Tracking.class);
            trackingList =
                    (ArrayList<Tracking>) criteria.add(Restrictions.eq("order.id", orderID)).list();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return trackingList;
    }
}
