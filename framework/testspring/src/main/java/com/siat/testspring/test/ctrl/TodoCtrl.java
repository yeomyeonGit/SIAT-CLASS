package com.siat.testspring.test.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siat.testspring.test.model.dto.TodoRequestDTO;
import com.siat.testspring.test.model.dto.TodoResponseDTO;
import com.siat.testspring.test.service.TestService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
@RequestMapping("/todo")  // endpoint : http://ip:port/todo
public class TodoCtrl {  

    @Autowired
    private TestService service ;

    // Create(쓰기)는 post
    // 데이터를 전달받는 Annotation
    // @RequestParam, @PathValues

    @GetMapping("/registerForm")
    public String form() {
        System.out.println("debug >>> todo ctrl   /registerForm");
        return "register";
    }
    

    @PostMapping("/insert") // endpoint : http://ip:port/todo/insert
    public String insert(TodoRequestDTO params) {
        System.out.println("debug >> todo ctrl   /insert" + params);
        int flag = service.insertService(params) ;

        if (flag != 0) {
            return "redirect:/";
        } else {
            return "xxxx" ;
        }
    }
    
    // http://localhost:8088/todo/read?seq=1
    @GetMapping("/read")
    public String read(@RequestParam int seq, Model model) {
        System.out.println("debug >>> todo ctrl/read?seq=" +seq);
        TodoResponseDTO response = service.readService(seq);
        model.addAttribute("read", response) ;  // 화면에 보여주기 위한 데이터 심어주기

        return "read";
    }
    
    // http://localhost:8088/todo/view/1
    @GetMapping("/view/{seq}")
    public String view(@PathVariable int seq, Model model) {
        System.out.println("debug >>> todo ctrl   /view/" +seq);
        TodoResponseDTO response = service.readService(seq) ;
        model.addAttribute("read", response) ;
    
        return "read";
    }
    
    @GetMapping("/delete") // http://localhost:8088/todo/delete?seq=1
    public String delete(@RequestParam int seq){
        System.out.println("debug >>> todo ctrl   /delete?seq=" +seq);
        int flag = service.deleteService(seq) ;
        if (flag != 0){
            return "redirect:/todo/select";
        }
        else {
            return "xxxx" ;
        }
        
    }

    @PostMapping("/update")
    public String update(@RequestParam String content ,
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
            return "redirect:/todo/select" ;
        } else {
            return "xxxx" ;
        }
    }

    @GetMapping("/select")
    public String select(Model model) {
        System.out.println("debug >>> todo ctrl  /select");
        List<TodoResponseDTO> list = service.selectService();
        model.addAttribute("list", list) ;
        return "list" ;
    }
    
    
}
