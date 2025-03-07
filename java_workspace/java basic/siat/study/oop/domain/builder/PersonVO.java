package siat.study.oop.domain.builder;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter

public class PersonVO {
    // 공통의 요소
    private String name ;   // private 접근 지정자는 자식이 접근하지 못한다
    private String addr ;

    // 각각의 구체적인 요소
    // private String subject ;
    // private String StuID ;
    // private String dept ;

    
    public String perInfo() {
        return "이름: " + this.getName() + "\t 주소 :" + this.getAddr()  ;
    }

    
    
}
