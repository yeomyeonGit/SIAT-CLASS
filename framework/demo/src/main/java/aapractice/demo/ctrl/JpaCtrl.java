package aapractice.demo.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aapractice.demo.dao.JpaSampleRepository;
import aapractice.demo.domain.dto.SampleRequestDTO;
import aapractice.demo.domain.dto.SampleResponseDTO;
import aapractice.demo.domain.entity.JpaSampleEntity;
import aapractice.demo.service.AuthenticationService;
import aapractice.demo.util.JwtProvider;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    
    @PostMapping("/sign-in")  // 토큰 - 로그인할 때 accessToken와 refToken이 생성됨
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

        
    @Transactional
    @PutMapping("/update")
    public String update(@RequestBody Map<String, String> params) {
        /*
        1. Entity 객체를 불러옴
        2. Transactional로 변화를 감지해야 함

        1) 데이터를 Entity로 만들기
        */

        /*
        Dirty Checking
        변경이 되면 자동으로 감지
        Entity의 최초 정보와 변경된 부분을 비교해서 자동으로 update

        JPQL - 어려움

         */

        // JpaSampleEntity entity = JpaSampleEntity.builder()
        //                                         .userId(params.get("userId"))
        //                                         .passwd(params.get("passwd"))
        //                                         .name(params.get("name"))
        //                                         .build() ;

        // # DynamicEntity 방법
        JpaSampleEntity entity = jpaSampleRepository
                            .findById(params.get("userId"))
                            .orElseThrow(() -> new RuntimeException("not found")) ;
        
        entity.setPasswd((params.get("passwd")));
        entity.setName(params.get("name"));
        
        // jpaSampleRepository.updateRow(params.get("userId"),
        //                               params.get("passwd"),
        //                               params.get("name"));
        return null;
    }

    @DeleteMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") String userId) {
        System.out.println("debug >>> jpaCtrl delete");
        jpaSampleRepository.deleteById(userId) ;
        return null ;
    }

    @GetMapping("/list")
    public ResponseEntity<List<SampleResponseDTO>> list() {
        System.out.println("debug >>> list");
        List<JpaSampleEntity> lst = jpaSampleRepository.findAll() ;
        // 리스트 안에 entity가 쫙 담겼음. 현재 메모리주소값 상태.
        // 여기서 JpaSampleEntity를 하나씩 꺼내줘야 함.
        // 코드 작업으로 DTO로 변환
        List<SampleResponseDTO> result = lst.stream()
                                            .map(SampleResponseDTO::new)
                                            .toList() ;

        // List<SampleResponseDTO> result = jpaSampleRepository.findByAll() ;
        return ResponseEntity.ok().body(result) ;
    }
}
