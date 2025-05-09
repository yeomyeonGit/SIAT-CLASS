package aapractice.demo.openapi.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aapractice.demo.openapi.domain.ForecastRequestDTO;
import aapractice.demo.openapi.domain.ForecastResponseDTO;
import jakarta.validation.Valid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/forecast")
public class ForecastCtrl {
    
    @Value("${openApi.serviceKey}")
    private String serviceKey ;
    @Value("${openApi.callbackUrl}")
    private String callbackUrl ;
    @Value("${openApi.dataType}")
    private String dataType ;

    @PostMapping("/getData")
    public ResponseEntity<List<ForecastResponseDTO>> getData(@Valid @RequestBody ForecastRequestDTO params) {
        System.out.println("debug >>> endpoint: /forecast/getData");
        System.out.println("debug >>> serviceKey: " + serviceKey);
        System.out.println("debug >>> callbackUrl " + callbackUrl);
        System.out.println("debug >>> dataType " + dataType);
        System.out.println("debug >>> params " + params);

        // 콜백 URL에 요청 파라미터를 보내는 것
        String requestURL = callbackUrl + "?serviceKey="+serviceKey+
                                          "&beach_num="+params.getBeach_num()+
                                          "&base_date="+params.getBase_date()+
                                          "&base_time="+params.getBase_time() ;
        System.out.println("debug >>> url check: " + requestURL);

        /////////////// 이 부분이 무슨 의미인지 궁금해 ~ !

        HttpURLConnection http   = null ; 
        InputStream       stream = null ; 
        String            result = null ;

        List<ForecastResponseDTO>  list  = null ;
        try {
            URL url = new URL(requestURL);
            http = (HttpURLConnection)url.openConnection();
            System.out.println("http connection = " + http ); 
            int code = http.getResponseCode() ;    // 통신이 정상적으로 됐나 보기
            System.out.println("http response code  = " + code );  
            if( code == 200 ) {
                stream = http.getInputStream() ; 
                result = readString(stream) ;
                System.out.println("result = " + result); 

            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        //////////////
        return null ;
    }

    public String readString(InputStream stream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        String input = null  ;
        StringBuilder result = new StringBuilder();
        while( (input = br.readLine() ) != null ) {
            result.append(input+"\n\r");
        }
        br.close();   
        return result.toString() ; 
    }
    
}
