package com.owly.delivery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.owly.delivery.entity.CreditCard;
import com.owly.delivery.entity.OrderRequestBody;
import com.owly.delivery.entity.Orders;
import com.owly.delivery.entity.User;
import com.owly.delivery.service.CreditCardService;
import com.owly.delivery.service.OrderService;
import com.owly.delivery.service.UserService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private UserService userService;

    @Autowired
    private CreditCardService creditCardService;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public int order(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        try {
            OrderRequestBody orderRequestBody = objectMapper.readValue(request.getReader(), OrderRequestBody.class);
            Orders order = orderRequestBody.getOrder();
            CreditCard creditCard = orderRequestBody.getCreditCard();

            String currentUserID = null;

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                currentUserID = authentication.getName(); // get email not userId
                System.out.println("currentUserName: " + currentUserID);
            } else {
                System.out.println("User not logged in, cannot find user name.");
            }


            // verify creditCard
            boolean isValidCreditCard = creditCardService.verifyCreditCard(creditCard);

            // verify the cardNumber and first name (test purpose)
            if (isValidCreditCard) {
                // save to database
                // get the current timestamp = createTime
                Timestamp instant = Timestamp.from(Instant.now());
                System.out.println("Order Create Time " + instant);
                // set to createTime in order
                order.setCreateTime(instant);
                // get userId from username
                User curUser = userService.getUser(currentUserID);
                order.setUser(curUser);
                int curUserId = curUser.getUserId();
                System.out.println("curUserId = " + curUserId);

                // save order to database
                orderService.saveOrder(order);
                System.out.println("order confirmed");

                // tes get List<Orders> By User
                for (Orders orderItem : curUser.getOrderList()) {
                    System.out.println(orderItem.getOrderId());
                }

                // get order Id
                System.out.println(order.getOrderId());
                return order.getOrderId();

            } else {
                System.out.println("payment failed, check the input");
                response.setStatus(HttpStatus.UNAUTHORIZED.value()); // response 401
            }
        }
        catch (Exception e){
            System.out.println("Error here");
            e.printStackTrace();
        }
        return 0;
    }
}
