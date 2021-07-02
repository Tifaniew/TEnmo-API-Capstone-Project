package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private UserDao dao;

    public UsersController(UserDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "users", method = RequestMethod.GET)
    public List getUsers() {
        return dao.findAll();
    }
}
