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
        SiatFunction lamFunction = (x, y) -> x > y ? x : y ;
        System.out.println(lamFunction.max(100, 20));
        
        SiatFunction lambdaSumFunc = (x, y) -> x + y ;
        System.out.println(lambdaSumFunc.max(100, 20));
        
        Supplier<String> supplier =  () -> "siat" ; 
        System.out.println( supplier.get() ); 

        Consumer<String> consumer =  (str) -> System.out.println(str.split(" ")[0]);
        consumer
            .andThen(System.out::println)    
            .accept("jslim siat");
            
        Function<String, Integer> function = (str) ->  str.length() ; 
        int len = function.apply("jslim siat");
        System.out.println(len);

        Predicate<String> predicate =  (str) -> str.equals("siat") ; 
        boolean flag = predicate.test("jslim") ;
        System.out.println( flag ); 
        
    }
}
