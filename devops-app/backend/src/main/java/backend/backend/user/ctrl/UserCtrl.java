package backend.backend.user.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.backend.user.domain.UserRequestDTO;
import backend.backend.user.domain.UserResponseDTO;
import backend.backend.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/user")
public class UserCtrl {

    @Autowired
    private UserService userService ;

    @GetMapping("/signIn")
    // @RequestBody는 post 방식에서 사용한다
    public ResponseEntity<UserResponseDTO> login(UserRequestDTO params) {
        System.out.println("debug >>> ctrl login");
        System.out.println("debug >>> params: " + params);
        UserResponseDTO response = userService.loginService(params) ;
        System.out.println(response);
        return ResponseEntity.ok().body(response) ;
    }
    @PostMapping("/signUp")
    // @RequestBody는 post 방식에서 사용한다
    public ResponseEntity<Void> signUp(@RequestBody UserRequestDTO params) {
        System.out.println("debug >>> ctrl signUp");
        System.out.println("debug >>> params: " + params);
        userService.signUpService(params) ;
        return ResponseEntity.noContent().build();
    }
    
}
