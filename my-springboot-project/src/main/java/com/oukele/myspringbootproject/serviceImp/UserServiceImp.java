package com.oukele.myspringbootproject.serviceImp;

import com.oukele.myspringbootproject.dao.UserMapper;
import com.oukele.myspringbootproject.entity.User;
import com.oukele.myspringbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;//这里出现红色波浪线，并不影响使用

    @Override
    public List<User> listAll() {
        return userMapper.selectAll();
    }
}
