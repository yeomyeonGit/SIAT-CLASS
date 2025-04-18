package com.siat.testsiat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.siat.testsiat.test.model.dto.TodoResponseDTO;
import com.siat.testsiat.test.service.TestService;

@SpringBootTest
public class ServiceApp {
    
    @Autowired
    private TestService testService ;

    @Test
    public void read() {
        System.out.println("debug >>> read");
        // given 
        int seq = 22 ; 
        // when 
        TodoResponseDTO response = testService.readService(seq);
        System.out.println("debug >>> "+response ); 
        // then 
        // assertNotNull() , assertEquals(), 
        Assertions.assertNotNull(response, "정상적으로 데이터를 읽지 못함"); 
    }
}
