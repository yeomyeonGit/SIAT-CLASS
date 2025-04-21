package com.siat.testspring.test.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siat.testspring.test.model.dto.TodoResponseDTO;
import com.siat.testspring.test.service.TestService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/react")
@CrossOrigin(origins = "http://localhost:3000")
public class ReactCtrl {

    @Autowired
    private TestService service ;

    @GetMapping("/select")
    public ResponseEntity<List<TodoResponseDTO>> select(@RequestBody TodoResponseDTO params) {
        System.out.println("debug >>> todo ctrl  /select");
        System.out.println("debug >>> react ctrl / select params: "+params);
        List<TodoResponseDTO> list = service.selectService();
        return ResponseEntity.ok(list) ;
    }
    
    
}
