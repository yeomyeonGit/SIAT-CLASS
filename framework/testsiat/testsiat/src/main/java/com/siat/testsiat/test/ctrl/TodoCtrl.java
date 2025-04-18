package com.siat.testsiat.test.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siat.testsiat.test.model.dto.TodoRequestDTO;
import com.siat.testsiat.test.model.dto.TodoResponseDTO;
import com.siat.testsiat.test.service.TestService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
@RequestMapping("/todo") // endpoint : http:// ip:port / todo
public class TodoCtrl {
    
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
    public String insert(TodoRequestDTO params) {
        System.out.println("debug >>> todo ctrl /insert "+params);
        int flag = service.insertService(params);
        if(flag != 0) {
            return "redirect:/" ;
        }else {
            return "xxxxx" ; 
        }
    }

    // endpoint : http://ip:port/todo/read?seq=1
    @GetMapping("/read")
    public String read(@RequestParam int seq, Model model) { 
        System.out.println("debug >>> todo ctrl /read "+seq);
        TodoResponseDTO response = service.readService(seq);
        model.addAttribute("read", response);
        return "read" ;
    }
    // endpoint : http://ip:port/todo/view/1
    @GetMapping("/view/{seq}")
    public String view(@PathVariable int seq, Model model) {
        System.out.println("debug >>> todo ctrl /view/{seq} "+seq);
        TodoResponseDTO response = service.readService(seq);
        model.addAttribute("read", response);
        return "read" ; 
    }

    // endpoint : http://ip:port/todo/delete?seq=1
    @GetMapping("/delete")
    public String delete(@RequestParam int seq) { 
        System.out.println("debug >>> todo ctrl /delete "+seq);
        int flag = service.deleteService(seq);
        if(flag != 0) {
            return "redirect:/todo/select" ;
        }else {
            return "xxxxx" ; 
        }
    }

    // endpoint : http://ip:port/todo/update
    @PostMapping("/update")
    public String update(@RequestParam String content , 
                         @RequestParam String status ,
                         @RequestParam int    seq) {
        System.out.println("debug >>> todo ctrl /update "+content);
        System.out.println("debug >>> todo ctrl /update "+status);
        System.out.println("debug >>> todo ctrl /update "+seq);
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        map.put("status", status);
        map.put("seq", seq);
        int flag = service.updateService(map);
        if(flag != 0) {
            return "redirect:/todo/select" ;
        }else {
            return "xxxxx" ; 
        }
    }
    // endpoint : http://ip:port/todo/select
    @GetMapping("/select")
    public String select(Model model) {
        System.out.println("debug >>> todo ctrl /select ");
        List<TodoResponseDTO> list =  service.selectService();
        model.addAttribute("list", list);
        return "list" ;
    }
    
    
    
    
    


    
        
}
