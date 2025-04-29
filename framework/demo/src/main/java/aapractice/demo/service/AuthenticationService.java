package aapractice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aapractice.demo.dao.AuthRepository;
import aapractice.demo.domain.UserRequestDTO;
import aapractice.demo.domain.UserResponseDTO;
import aapractice.demo.domain.entity.UserEntity;
import aapractice.demo.util.JwtProvider;

@Service
public class AuthenticationService {
    @Autowired
    private AuthRepository repository ;

    @Autowired
    private JwtProvider provider ;
    public UserResponseDTO loginService(UserRequestDTO params) {
        System.out.println("debug >>> service loginService ");
        // 토큰 두 개가 만들어짐
        String accToken = provider.generateAccToken(params.getEmail());
        String refToken = provider.generateRefToken(params.getEmail()) ;
        
        // DB에 저장되는 토큰은 refresh token
        // UserEntiy - JPA 방식으로 DB에 저장
        UserEntity entity = UserEntity.builder()
                                        .email(params.getEmail())
                                        .passwd(params.getPasswd())
                                        .refreshToken(refToken)
                                        .build() ;
                                        
        repository.save(entity) ;

        // 클라이언트에게 응답할 때는 accessToken과 refreshToken을 모두 헤더에 담아 response함
        UserResponseDTO response = UserResponseDTO.builder()
                                   .accessToken(accToken)
                                   .refreshToken(refToken)
                                   .build() ;

        // JPA 방식은 Response와 DB 반영을 따로따로 해야하나?
        return response ;
    }
}
