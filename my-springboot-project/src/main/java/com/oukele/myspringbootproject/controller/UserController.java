package com.oukele.myspringbootproject.controller;

import com.oukele.myspringbootproject.entity.User;
import com.oukele.myspringbootproject.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping(path = "/list")
    public List<User> getAll(){
        return userServiceImp.listAll();
    }
}
