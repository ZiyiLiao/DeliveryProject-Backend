package com.owly.delivery.service;


import com.owly.delivery.dao.UserDao;
import com.owly.delivery.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void signUp(User user) {
        user.setEnabled(true);
        userDao.signUp(user);
    }

    public User getUser(String email) {
        return userDao.getUser(email);
    }

}

