package siat.study.oop.domain.builder;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter   // 외부에서 접근해야 함

public class StudentVO extends PersonVO {   // PersonVO 클래스를 상속받는다
    
    private String stuID ;
    

    public String stuInfo() {
        return perInfo() + "\t 학번: " + this.getStuID() ;
        
    }


    
}

// PersonVO 클래스 말고 다른 부모 클래스를 상속받을 수 없다: 모호성 문제

