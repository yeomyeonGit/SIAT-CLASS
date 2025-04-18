package com.siat.testsiat.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siat.testsiat.test.dao.TestDao;
import com.siat.testsiat.test.dao.TestMapper;
import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper ;  
    
    public int insertService(TodoRequestDTO params) {
        System.out.println("debug >>> service insertService");
        return testMapper.insertRow(params);
    }   
    public List<TodoResponseDTO> selectService() {
        System.out.println("debug >>> service selectService");
        return testMapper.selectRow() ;
    }
    public int updateService(Map<String, Object> map) {
        System.out.println("debug >>> service updateService");
        return testMapper.updateRow(map);
    }
    public int deleteService(int seq) {
        System.out.println("debug >>> service deleteService");
        return testMapper.deleteRow(seq);
    }

    public TodoResponseDTO readService(int seq) {
        System.out.println("debug >>> service readService");
        return testMapper.readRow(seq);
    }
    
}
