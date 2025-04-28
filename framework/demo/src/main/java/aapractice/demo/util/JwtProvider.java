package aapractice.demo.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256) ;   // 암호화 알고리즘
    public String generateAccToken(String email) {
        System.out.println("debug >>> JwtProvideer access token generate");
        return Jwts.builder()
                    .setSubject(email) // 누구에 대한 토큰이냐?
                    .setIssuedAt(new Date())  // 토큰을 생성한 시간
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 20))
                    // 만료될 시간. 20분으로 세팅
                    .signWith(key)
                    .compact() ;
    }

    public String generateRefToken(String email) {
        System.out.println("debug >>> JwtProvideer access token generate");
        return Jwts.builder()
                    .setSubject(email) // 누구에 대한 토큰이냐?
                    .setIssuedAt(new Date())  // 토큰을 생성한 시간
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                    // 만료될 시간. 일주일로 세팅 (1000 => 1초)
                    .signWith(key)
                    .compact() ;

    }
    
}
