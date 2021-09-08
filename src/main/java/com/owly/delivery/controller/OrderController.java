package com.owly.delivery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.owly.delivery.entity.CreditCard;
import com.owly.delivery.entity.OrderRequestBody;
import com.owly.delivery.entity.Orders;
import com.owly.delivery.service.CreditCardService;
import com.owly.delivery.service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.sql.Timestamp;
import java.time.Instant;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CreditCardService creditCardService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/order")
    public void order(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        OrderRequestBody orderRequestBody = objectMapper.readValue(request.getReader(), OrderRequestBody.class);
        Orders order = orderRequestBody.getOrder();
        CreditCard creditCard = orderRequestBody.getCreditCard();

        String currentUserID = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserID = authentication.getName(); // get email not userId
            System.out.println("currentUserName: " + currentUserID);
        }
        else {
            System.out.println("User not logged in, cannot find user name.");
        }



        // verify creditCard
        boolean isValidCreditCard = creditCardService.verifyCreditCard(creditCard);

        // verify the cardNumber and first name (test purpose)
        if (isValidCreditCard){
            // save to database
            // get the current timestamp = createTime
            Timestamp instant= Timestamp.from(Instant.now());
            System.out.println("Order Create Time " + instant);
            // set to createTime in order
            order.setCreateTime(instant);
            orderService.saveOrder(order);
            System.out.println("order confirmed");

            // get the order number
            //int orderId  = orderService.getOrderIdByCreateTime(instant);
            //System.out.println("orderId from DB = " + orderId);

        } else {
            System.out.println("payment failed, check the input");
            response.setStatus(HttpStatus.UNAUTHORIZED.value()); // response 401

        }

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            String currentUserName = authentication.getName();
//            System.out.println("currentUserName: " + currentUserName);
//        }
//        else {
//            System.out.println("User not logged in, cannot find user name.");
//        }
    }
}
