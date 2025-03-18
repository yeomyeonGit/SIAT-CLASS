package todo.model.domain ;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// View에서 입력받을 데이터를 담는 변수들을 정의

@Builder
@Getter
@ToString

public class TodoRequestDTO {
    private int    seq ;
    private String title ;
    private String content ;
    private String startDate ;
    private String endDate ;
    private int    priority ;
}
