package com.siat.testspring.user.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siat.testspring.user.model.domain.UserRequestDTO;
import com.siat.testspring.user.model.domain.UserResponseDTO;
import com.siat.testspring.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
@RequestMapping("/user")
public class UserCtrl {
    @Autowired
    private HttpSession session ;

    @Autowired
    private UserService service ;

    @PostMapping("/login")
    public String login(UserRequestDTO params) {
        log.info(">>>>>>>>>>>> ctrl login params" + params) ;
        UserResponseDTO response = service.userService(params) ;
        // log.debug(">>>>>> response = "+ response);
        System.out.println(">>>>>> response = "+ response);
        session.setAttribute("UserSession", response);    
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        log.info("debug >>> 로그아웃 완료");
        return "redirect:/" ;
    }

    
    
    
}

