package com.siat.testspring.test.ctrl;


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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siat.testspring.test.model.dto.TodoRequestDTO;
import com.siat.testspring.test.model.dto.TodoResponseDTO;
import com.siat.testspring.test.service.TestService;

@RestController
@RequestMapping("/rest/todo")
public class TodoRestCtrl {
    @Autowired
    private TestService service ;

    @PostMapping("/insert") // endpoint : http://ip:port/todo/insert
    public ResponseEntity<String> insert(TodoRequestDTO params) {
        System.out.println("debug >> todo ctrl   /insert" + params);
        int flag = service.insertService(params) ;

        if (flag != 0) {
            return new ResponseEntity<String>("울랄라 맘마미아~", HttpStatus.OK);
        } else {
            return null ;
        }
    }
    
    // http://localhost:8088/todo/read?seq=1
    @GetMapping("/read")
    public ResponseEntity<TodoResponseDTO> read(@RequestParam int seq) {
        System.out.println("debug >>> todo ctrl/read?seq=" +seq);
        TodoResponseDTO response = service.readService(seq);
        return ResponseEntity.ok(response);
    }
    
    // http://localhost:8088/todo/view/1
    @GetMapping("/view/{seq}")
    public ResponseEntity<String> view(@PathVariable int seq) {
        System.out.println("debug >>> todo ctrl   /view/" +seq);
        TodoResponseDTO response = service.readService(seq) ;
    
        if (response != null) {
            return ResponseEntity.ok(response.getTitle());
        }

        else{
            return ResponseEntity.ofNullable("찾을 수 없음");
        }
        
    }
    
    @DeleteMapping("/delete") // http://localhost:8088/todo/delete?seq=1
    public ResponseEntity<String> delete(@RequestParam int seq){
        System.out.println("debug >>> todo ctrl   /delete?seq=" +seq);
        int flag = service.deleteService(seq) ;
        if (flag != 0){
            return ResponseEntity.ok("삭제 성공");
        }
        else {
            return ResponseEntity.ok("삭제 실패");
        }
        
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestParam String content ,
                         @RequestParam String status ,
                         @RequestParam int    seq,
                         @RequestParam int    priority) {
        
        System.out.println("debug >>> todo ctrl  /update"+content);
        System.out.println("debug >>> todo ctrl  /update"+status);
        System.out.println("debug >>> todo ctrl  /update"+seq);
        System.out.println("debug >>> todo ctrl  /update"+priority);

        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        map.put("status", status);
        map.put("seq", seq);
        map.put("priority", priority);

        int flag = service.updateService(map) ;

        if (flag != 0){
            return new ResponseEntity<>(HttpStatus.OK) ;
        } else {
            return null ;
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<TodoResponseDTO>> select() {
        System.out.println("debug >>> todo ctrl  /select");
        List<TodoResponseDTO> list = service.selectService();
        return ResponseEntity.ok(list) ;
    }
    
}
