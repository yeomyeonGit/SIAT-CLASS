package aapractice.demo.openapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)   // 오류를 낼 수 있는(오타나 내가 가져올 수 있는 프로퍼티 값이 없을 때) 데이터들을 무시해달라
public class ForecastResponseDTO {
    @JsonProperty("beachNum")
    private String beachNum ;

    @JsonProperty("baseDate")
    private String baseDate ;

    @JsonProperty("baseTime")
    private String baseTime ;

    @JsonProperty("category")
    private String category ;
    
    @JsonProperty("fcstDate")
    private String fcstDate ; 

    @JsonProperty("fcstTime")
    private String fcstTime ;

    @JsonProperty("fcstValue")
    private String fcstValue ;

    @JsonProperty("nx")
    private String nx ;

    @JsonProperty("ny")
    private String ny ; 
}
