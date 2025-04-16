package com.siat.testspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.siat.testspring.test.model.dto.TodoResponseDTO;
import com.siat.testspring.test.service.TestService;

@SpringBootTest
public class ServiceApp {
    
    @Autowired
    private TestService service ;
    
    @Test
    public void read() {
        System.out.println("debug >>> read");
        //given
        int seq = 29;
        // when
        TodoResponseDTO response = service.readService(seq) ;
        System.out.println("debug >>>" + response);
        // then
        // asswertNotNull, assertEquals()
        Assertions.assertNotNull(response, "정상적으로 데이터를 읽지 못함") ;

    }
}
