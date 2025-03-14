import java.util.List;
import java.util.Optional;

import siat.study.oop.domain.constructor.PersonVO;

/*
Optional ?
- 어떤 메서드가 null을 반환할지 확신할 수 없거나, null 처리를 놓쳐서 발생하는 예외를 피할 수 있는 것
- 예외 처리를 더 쉽게 할 수 있어 코드의 가독성이 높아지고, 유지 보수도 편하다
- ver 8
- Spring JPA(Java Persistance API)에서 많이 사용
주의사항)
- 사용 의도에 맞게 사용해야 한다 (null을 할당 X)
- 메서드의 반환 타입으로 사용 (전역 변수 타입 x, 매개변수 x)
- 기본 타입(primitive type) -> Wrapper Class(성능 저하 발생 가능) -> 원시타입 용도로 만들어진 클래스 사용 OptionalXXX 사용
*/

public class OptionalMain {
    public static void main(String[] args) {
        System.out.println("main start");

        OptionalApp app = new OptionalApp() ;
        Optional<PersonVO> result = app.findById(1L) ;   // 1L: int 1을 Long 형으로 바꾼다
        if (result.isPresent()) {
            System.out.println(result.get().perInfo() );
        };

        System.out.println(">>>");
        Optional<List<PersonVO>> list = app.getUsers() ;




        if (list.isPresent()) {
            list.get().stream().forEach(System.out::println);
        }


        // System.out.println( lst.size() );  // null이라서 메서드 사용 불가
        // System.out.println("main end");   // NullPointerException

        System.out.println(">>>> Optional 생성 방법");
        Optional<String> empty = Optional.empty() ;
        System.out.println(empty);
        Optional<String> opt = Optional.of("siat") ;
        // Optional<String> opt = Optional.of(null) ; // Error - NullPointerException
        
        
        Optional<String> optNull = Optional.ofNullable(null) ;
        System.out.println(optNull);

        System.out.println(">>>> 메서드 사용");
        if (opt.isPresent()) {
            System.out.println(opt.get()); // 꺼내오는 방법
        }
        // opt.ifPresent(str -> System.out.print(str)) ;
        opt.ifPresentOrElse(str -> System.out.println(str) , 
                            () -> System.out.println("empty") ) ;
        
        String value = empty.orElse("Default Value") ;
        System.out.println( value );
        System.out.println(empty.orElseGet(() -> "Default Lambda Value") ) ;
        // empty.orElseThrow(() -> new RuntimeException("message: because empty")) ;
        
        System.out.println(">>> filter");
        opt.filter(str -> str.length() > 4)
            .ifPresent(str -> System.out.println("filter value: "+ str));
        
        System.out.println(">>> map");
        opt.map(String::toUpperCase)    // 옵셔널을 반환하지 않음 (차이가 뭐지?)
            .ifPresent(str -> System.out.println(str)) ;

        opt.flatMap(str -> Optional.of(str)  // 옵셔널을 반환
                                    .map(String::toUpperCase))
            .ifPresent(str -> System.out.println(str));
        System.out.println(">>> end");
        

    }
    
}
