package com.owly.delivery.service;

import com.owly.delivery.dao.TrackingDao;
import com.owly.delivery.entity.Tracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackingService {
    @Autowired
    TrackingDao trackingDao;

    public List<Tracking> getTracking (int orderID) {
        List<Tracking> trackings = new ArrayList<Tracking>();
        trackings = trackingDao.getTrackingByOrderID(orderID);
        return trackings;
    }
}
