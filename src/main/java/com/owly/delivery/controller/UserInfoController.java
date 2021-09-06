package com.owly.delivery.controller;

import com.owly.delivery.entity.User;
import com.owly.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserInfoController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return userService.getUser(username);
    }


    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    @ResponseBody
    public User editUser(@RequestBody User newUser, HttpServletResponse response){
        User user = null;
        try{
            user = userService.editUser(newUser);
        } catch (Exception ex){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        if(user == null){
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        return user;

    }

}
