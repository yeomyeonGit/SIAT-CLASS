package siat.study.still;

public class StaticApp {
    
    public int nonStaticVar ; 
    public static int staticVar ;

    public static final int constVar = 10 ;


    public void nonSaticMethod() {
        nonStaticVar = 10 ;
        staticVar = 10 ; 
        int sum = nonStaticVar + staticVar ;
        System.out.println(">>> nonSaticMethod");
    }
    public static void staticMethod() {
        // ? -> 클래스 소유는 인스턴스 소유에접근 불가
        // nonStaticVar = 10 ; 
        System.out.println(">>> saticMethod");
    }

}
