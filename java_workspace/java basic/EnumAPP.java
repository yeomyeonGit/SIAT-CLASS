/*
 자바의 상수의 집합 타입: enum

 */

public enum EnumAPP {
    STU("학생"),
    EMP("매니저"),
    TEA("강사") ;

    // 라벨링
    
    private final String division ;
    private EnumAPP(String division) {
        this.division = division ;
    }

    public String getDivision() {
        return this.division ;
    }
}
