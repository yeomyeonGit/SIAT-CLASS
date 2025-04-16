package com.siat.testspring.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.siat.testspring.test.model.dto.TodoRequestDTO;
import com.siat.testspring.test.model.dto.TodoResponseDTO;

@Mapper // 객체 생성
public interface TestMapper {
    public int insertRow(TodoRequestDTO params);
    public List<TodoResponseDTO> selectRow();
    public int updateRow(Map<String, Object> map) ;
    public int deleteRow(int seq) ;

    public TodoResponseDTO readRow(int seq) ;
    
} 