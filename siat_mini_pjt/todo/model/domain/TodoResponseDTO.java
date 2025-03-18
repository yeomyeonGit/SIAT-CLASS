// VO의 역할: DB로부터 가져온 것을 여기에 담는다
package todo.model.domain ;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DB에 요청해서 받은 DB로부터 받은 데이터를 담는 변수 정의

@Builder
@Getter
@ToString

public class TodoResponseDTO {

    private int    seq ; 
    private String title ;
    private String content ;
    private String startDate ;
    private int    check ;
    private String endDate ;
    private int    priority ;
    
}