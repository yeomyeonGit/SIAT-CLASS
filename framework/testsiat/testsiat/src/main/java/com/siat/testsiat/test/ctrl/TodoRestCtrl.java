package com.siat.testsiat.test.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;
import com.siat.testsiat.test.service.TestService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/rest/todo")
public class TodoRestCtrl {

    @Autowired
    private TestService service ;

    // 데이터를 전달받는 Annoation 
    // @RequestParam , @PathValues

    // endpoint : http://ip:port/todo/registerForm
    @GetMapping("/registerForm") 
    public String form() {
        System.out.println("debug >>> todo ctrl /registerForm ");
        return "register" ;  
    }
    

    // endpoint : http://ip:port/todo/insert
    @PostMapping("/insert")
    // ResponseEntity<>
    public ResponseEntity<String> insert(TodoRequestDTO params) {
        System.out.println("debug >>> todo ctrl /insert "+params);
        int flag = service.insertService(params);
        if(flag != 0) {
            return new ResponseEntity<>("정상처리", HttpStatus.OK) ;
        }
        return null ;
    }

    // endpoint : http://ip:port/todo/read?seq=1
    @GetMapping("/read")
    public ResponseEntity<TodoResponseDTO> read(@RequestParam int seq) { 
        System.out.println("debug >>> todo ctrl /read "+seq);
        TodoResponseDTO response = service.readService(seq);
        return new ResponseEntity<TodoResponseDTO>(response, HttpStatus.OK); 
    }
    // endpoint : http://ip:port/todo/view/1
    @GetMapping("/view/{seq}")
    public ResponseEntity<TodoResponseDTO> view(@PathVariable int seq) {
        System.out.println("debug >>> todo ctrl /view/{seq} "+seq);
        TodoResponseDTO response = service.readService(seq);
        return new ResponseEntity<TodoResponseDTO>(response, HttpStatus.OK);
    }

    // endpoint : http://ip:port/todo/delete?seq=1
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("seq") int seq) { 
        System.out.println("debug >>> todo ctrl /delete "+seq);
        int flag = service.deleteService(seq);
        if(flag != 0) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT) ;
        }
        return null ;
    }

    // endpoint : http://ip:port/todo/update
    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestParam("content") String content , 
                         @RequestParam("status") String status ,
                         @RequestParam("seq") int    seq) {
        System.out.println("debug >>> todo ctrl /update "+content);
        System.out.println("debug >>> todo ctrl /update "+status);
        System.out.println("debug >>> todo ctrl /update "+seq);
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        map.put("status", status);
        map.put("seq", seq);
        int flag = service.updateService(map);
        if(flag != 0) {
            return new ResponseEntity<Void>(HttpStatus.OK) ;
        }else {
            return null ; 
        }
    }
    // endpoint : http://ip:port/todo/select
    @GetMapping("/select")
    public ResponseEntity<List<TodoResponseDTO>> select() {
        System.out.println("debug >>> todo ctrl /select ");
        List<TodoResponseDTO> list =  service.selectService();
        return new ResponseEntity<List<TodoResponseDTO>>(list, HttpStatus.OK) ;
    }
    
}
