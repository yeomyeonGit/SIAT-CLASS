package com.siat.testspring.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siat.testspring.test.dao.TestMapper;
import com.siat.testspring.test.model.dto.TodoRequestDTO;
import com.siat.testspring.test.model.dto.TodoResponseDTO;

@Service  // 객체생성, service 객체는 스프링 컨테이너에서 관리되고 있다
public class TestService {

    @Autowired   // 변수에 service 객체 주입 받기
    private TestMapper testMapper;

    public int insertService(TodoRequestDTO params){
        System.out.println("debug >>> service insertSertvice");
        return testMapper.insertRow(params) ;

    }
    public List<TodoResponseDTO> selectService(){
        System.out.println("debug >>> service insertSertvice");
        return testMapper.selectRow() ;

    }
    public int updateService(Map<String, Object> map){
        System.out.println("debug >>> service updateSertvice");
        return testMapper.updateRow(map) ;

    }
    public int deleteService(int seq){
        System.out.println("debug >>> service deleteSertvice");
        return testMapper.deleteRow(seq) ;

    }

    public TodoResponseDTO readService(int seq){
        System.out.println("debug >>> service readSertvice");
        return testMapper.readRow(seq) ;

    }

    
    
}
