/*
람다식은 하나의 메서드를 식으로 표현하는 것 
- 메서드 이름이 필요가 없다
- 익명메서드(일급객체)
- 불필요한 코드를 줄이고, 가독성을 높이기 위함
기존방식)
접근제어자 반환타입 메서드명([매개변수]) {
}
public String getName() {
    return "siat" ;
}
람다식)
(매개변수) -> { 실행문 }
() -> "siat" ;

[java 제공하는 함수형 인테페이스]
- Supplier<T>
: 매개변수없이 반환값만을 가지고 있는 함수형 인터페이스
- Consumer<T>
: 매개변수를 받아서 반환값이 없는 함수형 인터페이스
- Function<T,R>
: 매개변수를 받아서 반환값이 있는 함수형 인터페이스
- Predicate
: 매개변수를 받아서 Boolean 반환하는 함수형 인터페이스
*/


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import siat.study.lambda.SiatFunction;

public class LambdaMain {
    public static void main(String[] args) {

        // 직접 @FunctionalInterface로 정의하는 함

        // 먼저 정의해놓은 Function interface 사용. 매개변수로 2개를 넣을 거고, 2개를 비교하는 함수로 lambdaFunc 정의
        SiatFunction lambdaFunction = (x, y) -> x > y ? x : y ;
        System.out.println(lambdaFunction.max(100, 20));
        
        // 먼저 정의해놓은 Function interface 사용. 매개변수로 2개를 넣을 거고, 2개를 합산하는 함수로 lambdaSumFunc 정의
        SiatFunction lambdaSumFunc = (x, y) -> x + y ;
        System.out.println(lambdaSumFunc.max(100, 20));
        

        // 자바 라이브러리에서 제공하는 함수들
        // Supplier: 매개변수가 없고 반환값만 있는 함수형 인터페이스

        Supplier<String> supplier = () -> "siat" ;
        System.out.println(supplier.get());

        // Consumer: 매개변수가 있고 반환값이 없는 함수형 인터페이스
        // .accept(값) 으로 매개변수를 입력받고, 첫번째 함수부터 차례대로 실행, 매개변수를 andThen으로 다음 consumer로 전달하여 실행.
        // 체이닝 구조
        Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[0]) ;
        consumer
                .andThen(System.out::println)
                .accept("jslim siat");
        
        
        // Function: 매개 변수가 있고 반환값도 있는 함수형 인터페이스
        Function<String, Integer> function = (str) -> str.length() ;   // 적용할 함수를 정의
        // 입력으로는 String을 받고, 반환으로는 Integer를 반환하겠다는 뜻
        int len = function.apply("jslim siat") ;
        System.out.println(len);


        // Predicate: 입력값(매개변수)가 있고 반환값이 Boolean인 함수형 인터페이스
        Predicate<String> predicate = (str) -> str.equals("siat") ;

        boolean flag = predicate.test("jslim") ; 
        System.out.println(flag);
        
    }
}
