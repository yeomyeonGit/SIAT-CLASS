package com.siat.testspring.valid.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siat.testspring.test.model.dto.TodoRequestDTO;
import com.siat.testspring.valid.service.ValidService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/valid")
public class ValidTodoCtrl {
    @Autowired
    private ValidService service ;

    @PostMapping("/insert") // endpoint : http://ip:port/todo/insert
    public String insert(@Valid TodoRequestDTO params, BindingResult bindResult, Model model) {
        System.out.println("debug >> todo ctrl   /insert" + params);
        List<ObjectError> validErrors = bindResult.getAllErrors();
        
        if(bindResult.hasErrors()) {
            System.out.println("debug >>> valid errors has size: "+ validErrors.size());
            Map<String, String> map = new HashMap<>() ;
            for (int idx = 0; idx < validErrors.size() ; idx++) {
                FieldError field = (FieldError)validErrors.get(idx) ;
                System.out.println("code:"+ field.getCode());
                System.out.println("field:"+ field.getField());
                System.out.println("message:"+ field.getDefaultMessage());
                map.put(field.getField(), field.getDefaultMessage());
            }
            model.addAttribute("validError", map);
            return "register";
        } else {
            System.out.println("debug >>> valid errors has no error");
            int flag = service.insertService(params) ;
            return null ;
        }
    }

    // bindResult에 유효성검사를 통과하지 못한 정보를 담아서 넘겨준다.
    // 검증을 통과하지 못한 메시지들을 bindResult에 담는다
    
}
