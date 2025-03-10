package siat.study.oop.domain.builder;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter

public class TeacherVO extends PersonVO {

    private String subject ;

    public String teacherInfo() {
        return perInfo() + "\t 과목: " + this.getSubject() ;
        
    }

    // public String perInfo() {
    //     return super.perInfo() + "\t 과목: " + this.getSubject() ;
        
    // }
}
