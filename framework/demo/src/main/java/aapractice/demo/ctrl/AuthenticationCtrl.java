package aapractice.demo.ctrl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aapractice.demo.domain.UserRequestDTO;
import aapractice.demo.domain.UserResponseDTO;
import aapractice.demo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
// @RequiredArgsConstructor
public class AuthenticationCtrl {
    // private final AuthenticationService service ;

    @Autowired
    private AuthenticationService service ;
    
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO params) {
        System.out.println("debug >>>> ctrl login ");
        System.out.println("debug >>>> ctrl login params: " + params);
        UserResponseDTO response = service.loginService(params);
        System.out.println("debug >>> ctrl login result: "+ response);
        return ResponseEntity.ok()
                            .header("Autorization", "Bearer " + response.getAccessToken())
                            .header("Refresh-Token", response.getRefreshToken())
                            .body(response) ;
    }
    
    
}
