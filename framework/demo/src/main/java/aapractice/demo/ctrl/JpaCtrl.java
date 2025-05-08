package aapractice.demo.ctrl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aapractice.demo.dao.JpaSampleRepository;
import aapractice.demo.domain.entity.JpaSampleEntity;
import aapractice.demo.service.AuthenticationService;
import aapractice.demo.util.JwtProvider;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/jpa")
public class JpaCtrl {
    @Autowired
    private JpaSampleRepository jpaSampleRepository ;

    @Autowired
    private JwtProvider provider ;

    @PostMapping("/sign-up")
    public String signUp(@RequestBody Map<String, String> params) {
        System.out.println("debug >>> signup");

        // 원래 service에서 entity를 만들어야 함
        JpaSampleEntity entity = JpaSampleEntity.builder()
                                                .userId(params.get("userId"))
                                                .passwd(params.get("passwd"))
                                                .name(params.get("name"))
                                                .point(Integer.parseInt(params.get("point")))
                                                .build() ;
        jpaSampleRepository.save(entity) ;
        return null;
    }
    
    @PostMapping("/sign-in")
    @Transactional
    public String SignIn(@RequestBody Map<String, String> params) {
        System.out.println("debug >>> JpaCtrl signIn");

        String accToken = provider.generateAccToken(params.get("userId")) ;
        String refToken = provider.generateRefToken(params.get("userId")) ;
        JpaSampleEntity entity = jpaSampleRepository
                            .findByUserIdAndPasswd(params.get("userId"), params.get("passwd"))
                            .orElseThrow(() -> new RuntimeException("not found")) ;
        entity.setRefreshToken(refToken) ;
        return null ;
    }
    
}
