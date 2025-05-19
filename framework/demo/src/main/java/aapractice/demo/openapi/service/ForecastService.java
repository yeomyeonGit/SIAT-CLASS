package aapractice.demo.openapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import aapractice.demo.openapi.domain.ForecastResponseDTO;
import aapractice.demo.openapi.util.ForecastItems;

@Service
public class ForecastService {

    public List<ForecastResponseDTO> parsingJson(String str) {
        System.out.println("debug >>> ForecastSerivice parsingJson") ;
        ObjectMapper mapper = new ObjectMapper() ;  // 
        List<ForecastResponseDTO> list = null ;
        try {
            ForecastItems items = mapper.readValue(str, ForecastItems.class) ;
            // ForecastItems.class 이 타입의 객체 생성
            list = items.getItems() ;
            System.out.println("debug >>> list size" + list.size() );
            list.stream().forEach(System.out::println) ;
        } catch(Exception e) {
            e.printStackTrace() ;

        }
        // 구현

        return list ;
    }
    
}
