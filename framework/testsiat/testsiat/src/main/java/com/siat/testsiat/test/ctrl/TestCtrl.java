package com.siat.testsiat.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siat.testsiat.test.service.TestService;

/*
IOC(Inversion Of Control)
- DI(Dependency Inject)
- DL(Dependency LookUp)

객체 생성과 관련된 Annotation
- @Component, @Controller, @RestController, @Service, @Repository
사용자 요청과 관련된 Annotation
- @RequestMapping
의존성 관리를 위한 Annotation
- @Autowired, @Inject, @Resource, @Qualifier 
*/
@Controller
// user endpoint : http:// ip:port / context / test
@RequestMapping("/test")
public class TestCtrl {

    @Autowired
    private TestService service ;

    // user endpoint : http:// ip:port / context / test / insert 
    @RequestMapping("/insert")
    public String insert() {
        System.out.println("debug >>> ctrl insert");
        System.out.println("debug >>> ctrl inject : "+service);
        // service.testService();
        return "insert" ;
    }
    @RequestMapping("/update")
    public String update() {
        System.out.println("ctrl update");
        return "update" ;
    }
    @RequestMapping("/select")
    public String select() {
        System.out.println("ctrl select");
        return "select" ;
    }
    @RequestMapping("/delete")
    public String delete() {
        System.out.println("ctrl delete"); 
        return "delete" ;
    }
}

