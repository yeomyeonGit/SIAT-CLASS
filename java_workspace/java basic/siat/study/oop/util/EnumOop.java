package siat.study.oop.util;

import lombok.Builder;
import lombok.Getter;

public enum EnumOop {
    STU("학생"),
    EMP("매니저"),
    TEA("강사") ;

    // 라벨링
    
    private final String division ;
    private EnumOop(String division) {
        this.division = division ;
    }

    public String getDivision() {
        return this.division ;
    }
}
