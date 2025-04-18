package com.siat.testspring.valid.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siat.testspring.test.model.dto.TodoRequestDTO;
import com.siat.testspring.test.model.dto.TodoResponseDTO;
import com.siat.testspring.test.service.TestService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/valid")
public class RestValidTodoCtrl {

    @PostMapping("/insert") // endpoint : http://ip:port/todo/insert
    public ResponseEntity<Map<String, String>> insert(@Valid TodoRequestDTO params, BindingResult bindResult) {
        System.out.println("debug >> todo ctrl   /insert" + params);
        List<ObjectError> validErrors = bindResult.getAllErrors();
        System.out.println("debug >>> valid errors size: "+ validErrors.size());
        if(bindResult.hasErrors()) {
            Map<String, String> map = new HashMap<>() ;
            for (int idx = 0; idx < validErrors.size() ; idx++) {
                FieldError field = (FieldError)validErrors.get(idx) ;
                System.out.println("code:"+ field.getCode());
                System.out.println("field:"+ field.getField());
                System.out.println("message:"+ field.getDefaultMessage());
                map.put(field.getField(), field.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
        }
        
        return null ;
    }
    
}
