package aapractice.demo.ctrl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aapractice.demo.domain.UserRequestDTO;
import aapractice.demo.domain.UserResponseDTO;
import aapractice.demo.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
// @RequiredArgsConstructor
public class AuthenticationCtrl {
    // private final AuthenticationService service ;

    // Spring MVC archtecture - 서비스에 대한 의조성 주입
    @Autowired
    private AuthenticationService service ;
    
    // 경로 - 로그인: 토큰을 만들어줌
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO params) {
        System.out.println("debug >>>> ctrl login ");
        System.out.println("debug >>>> ctrl login params: " + params);
        UserResponseDTO response = service.loginService(params);
        System.out.println("debug >>> ctrl login result: "+ response);
        return ResponseEntity.ok()
                            .header("Authorization", "Bearer " + response.getAccessToken())
                            .header("Refresh-Token", response.getRefreshToken())
                            .body(response) ;

                            // 인가 방식을 Bearer 방식으로 쓰겠다
    }

    // 만료된 access token을 다시 발급해줌
    @PostMapping("/renew")
    public ResponseEntity<?> renewToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization") ;
        System.out.println("debug header >>> " + header);
        String token = header.substring(7) ;  // refresh token이 들어왔음
        System.out.println("debug >>>>> token : " + token);

        try {
            String newAccessToken = service.renewService(token) ;
            System.out.println("debug >>> 토큰 재발급 성공: " + newAccessToken);
            return ResponseEntity
                            .ok()
                            .header("Authorization", "Bearer " + newAccessToken)
                            .build() ;
        } catch(Exception e) {
            return ResponseEntity
                            .status(HttpStatus.FORBIDDEN).body("재발급 실패") ;
        }
  
    }
  
}
