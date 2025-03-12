/*
Collection API: List & Map을 제일 많이 사용
- List (중복을 허용, 순서 존재, 객체만 요로로 갖는다, 다양한 데이터 타입을 담을 수 있다, 가변 길이)
- Set (중복 허용 X, 순서 존재 X, 객체를 요소로 갖는다, 가변 길이)

(해당되지 않지만 같이 거론됨)
- Map ({ key : value}를 가지고 있는 자료 구조)

Wrapper Class: int -> Integer, boolean -> Boolean
- 8가지 기본 데이터 타입을 클래스로 바꾸는 이 클래스가 자동으로 적용됨
- 기본 타입 -> 참조 타입: boxing, 참조 -> 기본: Unboxing

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import siat.study.oop.domain.constructor.PersonVO;
import siat.study.oop.domain.constructor.TeacherVO;
import siat.study.oop.domain.constructor.StudentVO;
public class ArrayListMain {
    public static void main(String[] args) {
        // Array (배열)
        System.out.println(">>>>> Array");
        int [] ary = new int[5] ;
        ary[0] = 10 ; ary[1] = 20 ; ary[2] = 30 ; ary[3] = 40 ; ary[4] = 50 ;
        System.out.println("length = " + ary.length);
        ary[2] = 0 ;  // 참조타입의 경우 주소값이 없을 때 null로 표기 ;
        System.out.println(Arrays.toString(ary));


        System.out.println(">>>>> List: ArrayList");
        List lst = new ArrayList<>() ;
        lst.add(new StudentVO()) ;
        lst.add("jslim") ;
        lst.add(1) ;  // 기본데이터 타입은 객체가 아니라서 이론적으로 안됨
        lst.add(true) ;  // 하지만 Boxing이 돼서 가능
        System.out.println("length = "+ lst.size());
        lst.remove(0) ;
        System.out.println("length = "+ lst.size());
        System.out.println("get = "+ lst.get(0));

        System.out.println(">>> ");
        List<String> strLst = new ArrayList<String>() ;  // Generics - 리스트에 담을 수 있는 데이터 타입을 한정함
        // 다양한 타입을 담을 수 없고 문자열만 넣을 수 있음
        strLst.add("오늘 몸이 안 좋아");
        ///////////
        /// 제너릭스를 쓰면 불필요한 다운캐스팅을 지양할 수 있음
        
        List<PersonVO> perLst = new ArrayList<PersonVO>() ;
        perLst.add(new StudentVO("최여명", "서울", "2018")) ;
        perLst.add(new TeacherVO("최여명", "서울", "경제")) ;
        perLst.add(new TeacherVO("최여명", "서울", "개발")) ;

        for (int idx = 0 ; idx <perLst.size(); idx++) {
            PersonVO obj = perLst.get(idx) ;
            System.out.println(obj.perInfo());
        }

        System.out.println(" >>> Enhanced loop");

        System.out.println(" >>> Iterator");
        Iterator<PersonVO> ite = perLst.iterator() ;
        while (ite.hasNext()) {
            PersonVO per = ite.next();
            System.out.println(per.perInfo());
            
        }
        

    }
    
}
