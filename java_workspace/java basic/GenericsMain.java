/*
제너릭이란?
- 컴파일 시점의 타입의 안정성
- 불필요한 캐스팅을 지양
- 여러 데이터 타입을 표준화한 클래스를 만들 수 있음

T : 타입
K : 키
V : 밸류
E: 요소의 타입
 */

import java.util.ArrayList;
import java.util.List;

import siat.study.generic.Golf;
import siat.study.generic.MoldApp;
import siat.study.generic.ShortTrack;
import siat.study.generic.Skating;
import siat.study.generic.SpeedSkating;
import siat.study.generic.Sports;

public class GenericsMain {
    public static void main(String[] args) {
        String  [] strAry = new String[]{"siat", "java", "python"} ;  // 문자열 배열 생성과 동시에 초기화
        Integer [] intAry = new Integer[] {1, 2, 3, 4, 5} ;   // 정수형 배열 생성과 동시에 초기화

        printAry(strAry);   // 리스트 컬렉션을 만드는 코드
        printAry(intAry);


        //////////////////////////////
        ///// 객체를 호출해 Generics로 타입을 정하기 - 1) String
        
        MoldApp<String> app01 = new MoldApp<>() ;
        app01.setValue("Choi");
        System.out.println(app01.getValue());

        /*
        1. 객체를 생성 - 객체를 생성할 때 메서드 호출할 것을 고려해 매개변수와 반환값의 타입을 정하기 - set, get 고려
        2. set-get으로 설정됨!
        */


        //////////////////////////////
        ///// 객체를 호출해 Generics로 타입을 정하기 - 2) Integer
        /// 제너릭은 객체만 구분이 가능하다. int는 기본타입이라 객체가 아니기 때문에, Wrapper class인 Integer를 사용한다.

        MoldApp<Integer> app02 = new MoldApp<>();
        app02.setValue(1999);
        System.out.println(app02.getValue()) ;

        System.out.println(">>> 다형성");

        System.out.println(">>> 와일드 카드 : 하나 이상의 타입을 지정해야 하는 경우");
        
        /*
        <?> : 모든 타입을 허용한다
        <? extends XXXX> : 매개변수 선언시 사용
        <? super XXXX> : 선언시 사용
         */

        List< ? extends Sports> sportLst = new ArrayList<>() ;
        // sportLst.add(new Golf()) ; - Error: 상하위 클래스를 명확하게 구분할 수 없어 추가용으로 권장되지 않음. 읽기용으로 권장됨.

        List<? super Sports> cardLst = new ArrayList<>() ;
        // Sports 객체를 상속 받는 하위 객체를 담을 수 있는 리스트 선언. add 객체 추가용으로 적합.

        cardLst.add(new Golf()) ;
        cardLst.add(new Skating()) ;
        cardLst.add(new ShortTrack()) ;
        cardLst.add(new SpeedSkating()) ;

        
    }

        
    public static<T> void printAry(T [] ary) {
        for (T e : ary) {
            System.out.println( e );
        }
    }

    // public static<T> void printAry(T [] ary) {   // non-static에서 static 접근은 불가능
    //     for (T e: ary) {
    //         System.out.println( e );
    //     }
    // }

    
    
}
