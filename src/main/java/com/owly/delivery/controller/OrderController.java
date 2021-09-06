package com.owly.delivery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.owly.delivery.entity.CreditCard;
import com.owly.delivery.entity.OrderRequestBody;
import com.owly.delivery.entity.Orders;
import org.hibernate.criterion.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/order")
    public void order(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        OrderRequestBody orderRequestBody = objectMapper.readValue(request.getReader(), OrderRequestBody.class);
        Orders order = orderRequestBody.getOrder();
        CreditCard creditCard = orderRequestBody.getCreditCard();


    }
}
