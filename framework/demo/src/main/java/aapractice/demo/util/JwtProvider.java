package aapractice.demo.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
    // 토큰을 만드는 부분
    
    // private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256) ;   // 암호화 알고리즘
    // private final Key key = Keys.hmacShaKeyFor("siat-extremely-important-secret-key".getBytes(StandardCharsets.UTF_8)) ;
    

    // 토큰 서명
    // 보안을 위해 .env 파일에 JWT_SECRET_KEY 등록하고 yml에 # token 등록해둔 경로로 값에 접근
    // 서명을 위한 key를 생성
    @Value("${jwt.secret}")
    private String secret ;
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)) ; 
    }

    // 토큰을 만들 때는 대상, 생성 시간, 만료 시간을 명시해야 함. 그래서 토큰의 유효성을 필터에서 판단 가능
    // Access Token 생성
    public String generateAccToken(String email) {
        System.out.println("debug >>> JwtProvideer access token generate");
        return Jwts.builder()
                    .setSubject(email) // 누구에 대한 토큰이냐?
                    .setIssuedAt(new Date())  // 토큰을 생성한 시간
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 20))
                    // 만료될 시간. 20분으로 세팅
                    .signWith(getSigningKey())   // key 넣어서 서명
                    .compact() ;
    }

    // Refresh Token 생성
    public String generateRefToken(String email) {
        System.out.println("debug >>> JwtProvideer refresh token generate");
        return Jwts.builder()
                    .setSubject(email) // 누구에 대한 토큰이냐?
                    .setIssuedAt(new Date())  // 토큰을 생성한 시간
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                    // 만료될 시간. 일주일로 세팅 (1000 => 1초)
                    .signWith(getSigningKey())
                    .compact() ;

    }
    
}
