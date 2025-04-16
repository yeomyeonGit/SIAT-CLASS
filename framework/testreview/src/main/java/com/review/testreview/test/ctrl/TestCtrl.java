package com.review.testreview.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.review.testreview.test.service.TestService;


@Controller
@RequestMapping("/test")
public class TestCtrl {

    @Autowired
    private TestService service ;

    @RequestMapping("/insert")  // 요구사항 메서드
    public String insert() {
        System.out.println("ctrl insert");
        service.testService();
        return "insert" ; // 화면분기할 때: 논리적 이름에 따라 화면 분기.
        // ViewResolver - application.properties에서 경로와 확장자 설정.
        // JSP 인식을 위해 build.gradle에서 라이브러리 추가.
    }
    
}
