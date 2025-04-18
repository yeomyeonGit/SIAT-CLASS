package com.siat.testspring.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siat.testspring.user.dao.UserMapper;
import com.siat.testspring.user.model.domain.UserRequestDTO;
import com.siat.testspring.user.model.domain.UserResponseDTO;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper ;


    public UserResponseDTO userService(UserRequestDTO params) {
        return userMapper.loginRow(params) ;
    }
    
}
