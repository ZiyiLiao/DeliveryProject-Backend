package com.owly.delivery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.owly.delivery.entity.Tracking;
import com.owly.delivery.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TrackingController {
        @Autowired
        TrackingService trackingService;

        @RequestMapping(value = "/tracking")
        @ResponseBody
        public Tracking trackingList (HttpServletRequest request, HttpServletResponse response,
                @RequestParam(value = "orderID") int orderID) {
                System.out.println("orderID:" + orderID);
                Tracking tracking = trackingService.getTracking(orderID);
                return tracking;
        }
}
