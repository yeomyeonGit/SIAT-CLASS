package aapractice.demo.openapi.util;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import aapractice.demo.openapi.domain.ForecastResponseDTO;
import lombok.Getter;

@Getter
public class ForecastItems {

    @JsonProperty("Item")
    private List<ForecastResponseDTO> items ;

    // 노드로 만들기
    @JsonCreator
    public ForecastItems(@JsonProperty("response") JsonNode node) {
        try {
            ObjectMapper mapper = new ObjectMapper() ;
            JsonNode item = node.findValue("item") ;
            ForecastResponseDTO[] ary = mapper.treeToValue(item, ForecastResponseDTO[].class) ;
            items = Arrays.asList(ary) ;
        
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
