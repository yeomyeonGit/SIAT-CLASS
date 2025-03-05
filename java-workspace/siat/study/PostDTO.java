package siat.study;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter     // 실질적으로 setter를 쓰는 건 권장되지 않는다
@NoArgsConstructor   // 기본생성자
@AllArgsConstructor  // special constructor
@Builder  // builer 방식으로 객체 생성을 하겠다 @AllArgsConstructor와 함께 쓰여야 함

public class PostDTO {

    // 멤버(전역) 변수

    private String title ;     // 접근제어자가 private이라 외부에서 이 변수들에 접근할 수는 없지만
    private String regDate ;     // 클래스 내에 정의하는 메서드에 의해 접근할 수 있다
    private String writer ;     // 메서드를 통해 접근하면 외부에서도 이 변수들에 접근할 수 있다
    private String content ;
    private String viewCnt ;
    private String comment ;
    

}
