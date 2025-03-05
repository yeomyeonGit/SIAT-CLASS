package siat.study.still;

import lombok.*;

@Builder

public class StaticApp {

    public int nonStaticVar ;  // 이 변수는 클래스 소유가 아니라 인스턴스 소유
    public static int staticVar ;
    // 이렇게 static을 붙이면 더이상 인스턴스 소유가 아니라 클래스 소유
    // 따라서 main 메서드에서 '(클래스 이름).메서드/변수'로 호출해서 접근할 수 있다

    public static final int constVar = 10;
    // final은 상수
    // public static final int constVar ; 따라서 이렇게 값을 할당하지 않으면 error

    public void nonStaticMethod() {
    // static이 아닌 메서드는 static 변수 및 메서드를 가져올 수 있다 - 원리: 메모리 관련
        nonStaticVar = 10;
        staticVar = 10;

        System.out.println(">>> staticMethod");
    }

    public static void staticMethod() {
        // nonStaticVar = 10; // Error: static은 nonStatic에 바로 접근할 수 없다
        // 원리: 메모리 관련
        System.out.println(">>> staticMethod");
        
        
    }

    

    
    
}
