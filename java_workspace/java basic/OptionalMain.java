import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import siat.study.oop.domain.constructor.PersonVO;

/*
Optional ?
- 어떤 메서드가 null을 반환할지 확신할 수 없거나, null 처리를 놓쳐서 발생하는 예외를 피할 수 있는 것
- 예외 처리를 더 쉽게 할 수 있어 코드의 가독성이 높아지고, 유지 보수도 편하다
- ver 8
- Spring JPA(Java Persistance API)에서 많이 사용

주의사항
- 사용 의도에 맞게 사용해야 한다 (null을 할당 X)
- 메서드의 반환 타입으로 사용 (전역 변수 타입 x, 매개변수 x)
- 기본 타입(primitive type) -> Wrapper Class(성능 저하 발생 가능) -> 원시타입 용도로 만들어진 클래스 사용 OptionalXXX 사용
*/

public class OptionalMain {
    public static void main(String[] args) {
        System.out.println("main start");

        // 1. getStr() 메서드 호출
        OptionalApp app = new OptionalApp() ;
        System.out.println("옵셔널 아님(String) & null 반환: "+ app.getStr());

        // 2. findById() 메서드 호출하기
        Optional<PersonVO> result = app.findById(1L) ;
        System.out.println("옵셔널 출력: " + result);   
        // 출력: Optional[siat.study.oop.domain.constructor.StudentVO@14ae5a5]
        // 개념: 참조 타입을 바로 출력하면 객체의 옵셔널[주소]값이 나온다

        System.out.println(result.get());   // 옵셔널 메서드 .get() 사용. 이러면 Optional만 빠진 주소값이 나온다.
        if (result.isPresent()) {
            System.out.println("객체의 메서드 출력: " + result.get().perInfo());   // 객체를 가져온 거니까 객체의 메서드를 가져오면 됨
        }
        
        System.out.println(">>>");
        Optional<List<PersonVO>> list = app.getUsers() ;
        // Optional<List<PersonVO>> list = app.getUsers() ;


        if (list.isPresent()) {
            list.get().stream().forEach(System.out::println);
        }


        // System.out.println( lst.size() );  // null이라서 메서드 사용 불가
        // System.out.println("main end");   // NullPointerException

        System.out.println(">>>> Optional 생성 방법");
        // 빈 Optional 생성
        Optional<String> empty = Optional.empty() ;
        System.out.println("빈 옵셔널: " + empty);

        // 속 찬 Optional 생성.
        Optional<String> opt = Optional.of("siat") ;
        System.out.println("null이 아닌 옵셔널: "+ opt.get());

        // Optional<String> opt01 = Optional.of(null) ; // Error - NullPointerException
        // .of 옵셔널 메서드를 쓸 때 null 값을 넣는 것은 불가능하다
        
        // Null 값을 담는 옵셔널 생성 .ofNullable(null) 옵셔널 메서드 사용
        // Null값이 아니어도 담을 수 있음
        Optional<String> optNull = Optional.ofNullable(null) ;
        System.out.println("null을 반환할 수 있는 옵셔널: "+ optNull);
        // Optional<String> optNull = Optional.ofNullable(null) ;
        // System.out.println(optNull);

        System.out.println(">>>> 옵셔널 메서드 사용: .isPresent()");

        if (opt.isPresent()) {
            System.out.println(opt.get());
        }

        System.out.println(">>>> 옵셔널 메서드 사용: .ifPresent(consumer 람다식)");
        opt.ifPresent(str -> System.out.println(str));

        // opt.ifPresentOrElse( str -> System.out.println(str) , 
        //                     () -> System.out.println("empty") ) ;  이 부분 오류 해결하기
        
        System.out.println(">>>> 옵셔널 메서드 사용: .orElse()");

        //orElse(값) 메서드: Optional 변수에 값이 할당돼 있으면 그 값을 반환, empty나 null 이면 값을 할당하는 메서드

        String value = empty.orElse("Default Value" ) ;
        String value01 = opt.orElse("Default Value" ) ;
        String value02 = optNull.orElse("Default Value" ) ;
        System.out.println( value );
        System.out.println( value01 );
        System.out.println( value02 );

        System.out.println(".orElseGet(람다식): empty거나 null이면 람다식을 수행한 값을 반환한다. 아니면 원래 값을 반환한다");
        System.out.println(empty.orElseGet(() -> "Default Lambda Value"));
        System.out.println(opt.orElseGet(() -> "if there is a value"));

        System.out.println(">>>> .orElseThrow() 오류 처리");
        opt.orElseThrow(() -> new RuntimeException("message: .orElseThrow()는 값이 없을 경우(null) 예외 처리")) ;
        // empty.orElseThrow(() -> new RuntimeException("message: because empty")) ;
        
        System.out.println(">>> filter");
        opt.filter(str -> str.length() >= 4)
            .ifPresent(str -> System.out.println(str));
        
        
        System.out.println(">>> map");
        System.out.println("Optional map: "+ opt.map(String::toUpperCase)) ;

        opt.map(String::toUpperCase)    
            .ifPresent(str -> System.out.println(str)) ;
        
        opt.flatMap(str -> Optional.of(str)  
            .map(String::toUpperCase))
            .ifPresent(str -> System.out.println(str));

        System.out.println(">>> map과 flatMap의 차이");    // map은 중첩으로도 optional을 반환
        System.out.println(opt.map(str -> Optional.of(str)  
                                    .map(String::toUpperCase))) ;
        
        System.out.println(opt.flatMap(str -> Optional.of(str)   // flatMap은 중첩으로 optional을 반환하지 않음
                                    .map(String::toUpperCase))) ;                            
            
        System.out.println(">>> end");
        

    }
    
}


/*
flatMap과 map의 차이
 */