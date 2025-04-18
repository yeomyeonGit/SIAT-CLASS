package com.siat.testspring.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.siat.testspring.user.model.domain.UserRequestDTO;
import com.siat.testspring.user.model.domain.UserResponseDTO;

@Mapper
public interface UserMapper {
    public UserResponseDTO loginRow(UserRequestDTO params) ;
} 
