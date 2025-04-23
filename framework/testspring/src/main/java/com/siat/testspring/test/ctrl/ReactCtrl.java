package com.siat.testspring.test.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siat.testspring.test.model.dto.TodoResponseDTO;
import com.siat.testspring.test.service.TestService;
import com.siat.testspring.user.model.domain.UserRequestDTO;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/react")
public class ReactCtrl {

    @Autowired
    private TestService service ;

    @PostMapping("/login")
    public ResponseEntity<Void> postMethodName(@RequestBody UserRequestDTO params) {
        System.out.println("debug >>> react ctrl /login");
        System.out.println("debug >>> react ctrl /login params: "+ params);
        // 204 == noContent
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<TodoResponseDTO>> postMethodName() {
        System.out.println("debug >>> react ctrl /list");
        List<TodoResponseDTO> list = service.selectService();
        // 204 == noContent
        return new ResponseEntity<List<TodoResponseDTO>>(list, HttpStatus.OK);
    }
    
    
    // @GetMapping("/select")
    // public ResponseEntity<List<TodoResponseDTO>> select(@RequestBody TodoResponseDTO params) {
    //     System.out.println("debug >>> todo ctrl  /select");
    //     System.out.println("debug >>> react ctrl / select params: "+params);
    //     List<TodoResponseDTO> list = service.selectService();
    //     return ResponseEntity.ok(list) ;
    // }
    
    
}
