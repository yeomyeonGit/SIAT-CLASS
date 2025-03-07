package siat.study.oop.domain.builder;

import javax.annotation.processing.Generated;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter

public class ManagerVO extends PersonVO {
    private String dept ;

    

    public String managerInfo() {
        return perInfo() + "\t 부서: " + dept;
    }

    
    
}
