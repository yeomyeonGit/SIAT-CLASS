package com.siat.testspring.valid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siat.testspring.test.model.dto.TodoRequestDTO;
import com.siat.testspring.valid.dao.ValidDAO;
import com.siat.testspring.valid.domain.entity.TodoEntity;


@Service
public class ValidService {
    @Autowired
    private ValidDAO dao ;

    public int insertService(TodoRequestDTO params) {
        System.out.println("debug >>> service insert service");
        TodoEntity entity = TodoEntity.builder()
                                        .content(params.getContent())
                                        .title(params.getTitle())
                                        .priority(params.getPriority())
                                        .build();
        dao.save(entity) ;
        
        return 1 ;
    }   
}
