package aapractice.demo.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
브라우저 요청(get, post, put, delete) 요청 전에 자동으로 OPTIONS(preflight request)라는 요청을 먼저 보냄.
필터를 통해서 jwt 검사를 하게 되면 cors 에러
*/

/*
filter로는 모든 리퀘스트가 들어옴
 */

@Component
public class JwtFilter implements Filter {
    // key: 256비트. provider의 키와 일치시켜야 함
    @Value("${jwt.secret}")
    private String secret ;
    private Key key = null ;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)) ;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
        System.out.println("debug >>> Filter");
        HttpServletRequest req = (HttpServletRequest) request ;
        HttpServletResponse res = (HttpServletResponse) response ;
        String path = req.getRequestURI() ;
        System.out.println(("debug >>> client path : "+ path));

        String method = req.getMethod() ;
        System.out.println("debug >>> client method: " + method);

        // CORS 문제 해결
        if ("OPTIONS".equalsIgnoreCase(method)) {
            res.setStatus(HttpServletResponse.SC_OK);
            // res.setHeader("Access-Control-Allow-Origin", "*");
            // res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            // res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
            chain.doFilter(request, response);
            return ;
        }

        if (isPassPath(path)) {
            System.out.println("debug >>> 인증이 필요없는 경로는 필터 통과, 컨트롤러 이동");
            chain.doFilter(request, response);
            return ;
        }

        // 헤더 확인 작업
        String authHeader = req.getHeader("Authorization") ;
        System.out.println("debug >>> authHeader : " + authHeader);

        // 토큰에 문제가 생기면 바로 리턴
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("debug >>> if true authHeader 확인");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED) ;
            return ;
        }

        // 앞에 Bearer 7자리만 잘라서 토큰값만 가져오려고 subString을 쓴다.
        String token = authHeader.substring(7) ;
        System.out.println("debug >>>>> token : " + token);
        try {
            // JWT(서명과 유효기간 체크)
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token) ;
            System.out.println("debug >>>> 寃�利앹꽦怨� -> 而⑦듃濡ㅻ윭濡� �대룞");
            chain.doFilter(request, response);

        } catch(Exception e) {
            e.printStackTrace();
            
            res.setStatus(res.SC_FORBIDDEN);
            
            res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
            res.setHeader("Access-Control-Allow-Credentials", "true");
            res.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
            
            chain.doFilter(request, response);
            return ;
        }
    }

    // 특정 URL은 검증없이 컨트롤러로 넘긴다.
    // 토큰 검증을 할 필요 없는 request 경로를 등록해주는 작업
    public boolean isPassPath(String path) {
        return path.startsWith("/swagger-ui") ||
               path.startsWith("/v3/api-docs") ||
               path.startsWith("/swagger-resources") ||
               path.startsWith("/swagger-ui") ||
               path.startsWith("/h2-console") ||
               path.startsWith("/auth") ||
               path.startsWith("/user") ||
               path.startsWith("/jpa") ;
    }
}
