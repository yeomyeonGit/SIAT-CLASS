package backend.backend.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backend.user.dao.UserMapper;
import backend.backend.user.domain.UserRequestDTO;
import backend.backend.user.domain.UserResponseDTO;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper ;
    
    public UserResponseDTO loginService(UserRequestDTO params) {
        System.out.println("debug >>> service loginService");
        return userMapper.signIn(params) ;
        // return null ;
    }

    public void signUpService(UserRequestDTO params) {
        System.out.println("debug >>> service signUpService");
        userMapper.signUp(params);
    }
}
