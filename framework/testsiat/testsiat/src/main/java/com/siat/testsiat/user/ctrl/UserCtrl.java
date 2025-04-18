package com.siat.testsiat.user.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siat.testsiat.user.model.domain.UserRequestDTO;
import com.siat.testsiat.user.model.domain.UserResponseDTO;
import com.siat.testsiat.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j   // simple logging facade for java
/*
trace : 추적
debug : 디버깅 정보성 메시지를 출력할 때
info : 상태변경이나ㅓ 정보성 메시지를 출력할 때
warn : 에러의 원인이 될 수 있는 경고성 메시지를 출력
error : 요청처리에 문제가 생겼을 때
 */
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
        log.debug(">>>>>> response = "+ response);
        session.setAttribute("UserSession", response);    
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }


    
    
    
}
