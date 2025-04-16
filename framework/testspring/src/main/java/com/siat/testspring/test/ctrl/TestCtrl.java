package com.siat.testspring.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siat.testspring.test.service.TestService;

/*
스프링 프레임워크의 핵심
IOC(Inversion of Control)
- DI(Dependency Injection)
- DL(Dependency Lookup)



객체 생성과 관련된 Annotation
@Component, @Controller, @RestController @Service, @Repository(DAO)
생성된 객체가 컨테이너에 등록됨

사용자 요청과 관련된 Annotation
- @RequestMapping

의존성 관리를 위한 Annotation
@Autowired, @Inject, @Resource, @Qualifier
 */
@Controller  // 객체 생성
// user endpont: http:// ip:port / context / test
@RequestMapping("/test") // 리퀘스트
public class TestCtrl {

    @Autowired // 의존성 주입
    private TestService service ;

    // user endpont: http:// ip:port / user / insert
    // 사용자와 관련된 기능 중 insert 메서드 실행
    @RequestMapping("/insert") // 요구사항 매핑
    public String insert() {
        System.out.println("debug >>> ctrl insert");
        System.out.println("debug >>> ctrl insert:" + service);
        // service.testService();
        return "insert" ;
        // 반환하고 싶은 페이지의 논리적 이름만 반환하면 ViewResolver가 해당하는 jsp를 불러옴
    }

    // user endpont: http:// ip:port / test / update
    @RequestMapping("/update")
    public String update() {
        System.out.println("ctrl update");
        return "update" ;
    }

    // user endpont: http:// ip:port / test / insert
    @RequestMapping("/select")
    public String select() {
        System.out.println("ctrl select");
        return "select" ;
    }

    // user endpont: http:// ip:port / test / insert
    @RequestMapping("/delete")
    public String delete() {
        System.out.println("ctrl delete");   // 클래스가 아니라 메서드로 간다
        return "delete" ;
    }
    
}

// 메서드 매핑의 관점
// '/'는 루트 디렉토리
// user endpont: http:// ip:port / user / insert
// user라는 클래스의 insert 메서드 실행
// 스프링프레임워크는 기본적으로 화면 분기 방식이 forward