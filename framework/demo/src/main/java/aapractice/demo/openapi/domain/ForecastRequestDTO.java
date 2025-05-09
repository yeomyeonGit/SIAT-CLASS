package aapractice.demo.openapi.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data   // 종합선물세트 (빌더패턴 아닌 setter getter 등)
public class ForecastRequestDTO {
    @NotNull(message = "형식) 1")
    private String beach_num ;
    @NotNull(message = "형식) 20220622")
    private String base_date ;
    @NotNull(message = "형식) 1100")
    private String base_time ;
    
}
