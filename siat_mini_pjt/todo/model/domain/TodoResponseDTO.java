// VO의 역할: DB로부터 가져온 것을 여기에 담는다
package todo.model.domain ;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DB에 요청해서 받은 DB로부터 받은 데이터를 담는 변수 정의

@Builder
@Getter
@ToString
@Setter

public class TodoResponseDTO {

    private int     seq ; 
    private String  title ;
    private String  content ;
    private Date    startDate ;
    private int     check ;   // 사라져야 하는데 기존 코드에 오류 생길 수 있으니까
    private String  status ;  // 이걸 대신해서 추가
    private Date    endDate ;
    private int     priority ;
    
}