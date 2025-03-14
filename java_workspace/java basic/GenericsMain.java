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
        String [] strAry = new String[]{"siat", "java", "python"} ;
        Integer[] intAry = new Integer[]{1, 2, 3, 4, 5} ;  // 배열 생성과 동시에 초기화 문법

        printAry(strAry);   // 리스트 컬렉션을 만드는 코드
        printAry(intAry);


        //////////////////////////////
        
        MoldApp<String> app01 = new MoldApp<>() ;
        app01.setValue("jslim");
        System.out.println(app01.getValue());

        MoldApp<Integer> app02 = new MoldApp<>() ;
        app02.setValue(127);
        System.out.println(app02.getValue());

        System.out.println(">>> 다형성");

        System.out.println(">>> 와일드 카드 : 하나 이상의 타입을 지정해야 하는 경우");
        
        /*
        <?> : 모든 타입을 허용한다
        <? extends XXXX> : 매개변수 선언시 사용
        <? super XXXX> : 선언시 사용
         */

        // List<? extends Sports> sportLst = new ArrayList<>() ;
        List<? super Sports> cardLst = new ArrayList<>() ;
        cardLst.add(new Golf()) ;
        cardLst.add(new Skating()) ;
        cardLst.add(new ShortTrack()) ;
        cardLst.add(new SpeedSkating()) ;

        
    }

    public static<T> void printAry(T [] ary) {   // non-static에서 static 접근은 불가능
        for (T e: ary) {
            System.out.println( e );
        }
    }

    
    
}
