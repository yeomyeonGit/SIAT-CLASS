package aapractice.demo.service;

import java.util.Optional;

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
        
        // # DB에 저장되는 토큰은 refresh token
        // # UserEntiy - JPA 방식으로 DB에 저장
        
        // # 무조건 생성하는 코드
        // UserEntity entity = UserEntity.builder()
        //                                 .email(params.getEmail())
        //                                 .passwd(params.getPasswd())
        //                                 .refreshToken(refToken)
        //                                 .build() ;

        // # db에 존재하면 갱신, 없으면 저장
        // select * where email = ? , 수행 후 객체 반환
        Optional<UserEntity> op = repository.findByEmail(params.getEmail()) ;
        // refresh token이 db에 있다
        // 시간이 경과한 후 로그인할 때 refresh token으로 access token을 만들어야 함
        // 주의::: 토큰은 원래 헤더에 담아야 함. response가 아니라.
        if (op.isPresent()) {
            UserEntity result = op.get() ; 
            UserResponseDTO response = UserResponseDTO.builder()
                                    .email(result.getEmail())
                                    .passwd(result.getPasswd())
                                    .refreshToken(result.getRefreshToken())   // db에 있는 토큰을 담아줘야 함
                                    .accessToken(accToken)  // 생성해서 담아주는 코드
                                    .build() ;
            
            return response ;

        } else {
            UserEntity entity = UserEntity.builder()
                                        .email(params.getEmail())
                                        .passwd(params.getPasswd())
                                        .refreshToken(refToken)
                                        .build() ;

            repository.save(entity) ;

            UserResponseDTO response = UserResponseDTO.builder()
                                    .email(params.getEmail())
                                    .passwd(params.getPasswd())
                                    .refreshToken(refToken)   // db에 있는 토큰을 담아줘야 함
                                    .accessToken(accToken)  // 생성해서 담아주는 코드
                                    .build() ;

            return response ;
        }
        // 클라이언트에게 응답할 때는 accessToken과 refreshToken을 모두 헤더에 담아 response함
        
        // JPA 방식은 Response와 DB 반영을 따로따로 해야하나?
    }

    // access token 재발급 과정
    public String renewService(String token) throws Exception {
        System.out.println("debug >>> service renewService");
        Optional<UserEntity> op = repository.findByRefreshToken(token) ;

        if (op.isPresent()) {   // 유효한 토큰
            String email = provider.renewToken(op.get().getRefreshToken()) ;
            String newToken = provider.generateAccToken(email);
            return newToken ;
        } else {   // 유효하지 않은 토큰
            throw new Exception() ;

        }
    }
}
