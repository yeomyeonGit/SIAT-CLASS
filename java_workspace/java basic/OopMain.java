import siat.study.oop.domain.constructor.StudentVO;
import siat.study.oop.domain.constructor.TeacherVO;
import siat.study.oop.domain.constructor.ManagerVO;
import siat.study.oop.domain.constructor.PersonVO;


public class OopMain {
    /*
    OOP (Object Oriented Programming)
    - 은닉화: 정보를 숨긴다 (Information hiding), 심화: 객체 타입을 숨긴다
    - 상속
    - 다형성(타입, 매개변수, 메서드)
    - 추상화
     */

     public static void main(String[] args) {
        StudentVO stu = new StudentVO("최여명", "종로구", "2018") ;
        System.out.println(stu.perInfo());
        System.out.println(stu.stuInfo());

        System.out.println("구분 >>>");

        TeacherVO teacher = new TeacherVO("임정섭", "지구", "개발") ;
        System.out.println(teacher.perInfo());
        System.out.println(teacher.teacherInfo());
     
        System.out.println("구분 >>>");

        ManagerVO manager = new ManagerVO("이진규", "건대", "자영업") ;
        System.out.println(teacher.perInfo());
        System.out.println(manager.managerInfo());

        // 빌더 패턴을 이용한 상속
        // PersonVO per = PersonVO.builder()
        //                 .name("임정섭")
        //                 .addr("서울")
        //                 .build() ;

        /////////////////////////////////////////////// 다형성
        
        PersonVO stu01 = new StudentVO("박신형", "노량진", "2018") ;
        // PersonVO 타입의 인스턴스로 StudentVO 객체를 생성한다
        System.out.println(stu01.perInfo());
        // 가능한 이유: stu01의 타입은 본인의 클래스에 정의된 메서드에 접근할 수 있음
        // System.out.println(stu01.stuInfo()); //Error. 타입이 StudentVO가 아니기 때문
        System.out.println(((StudentVO)stu01).stuInfo()); // 다운캐스팅

        // 부모클래스에서 자식 클래스로는 명시적 형변환이 필요함

        PersonVO manager01 = new ManagerVO("이진규", "건대", "자영업") ;
        PersonVO teacher01 = new TeacherVO("임정섭", "지구", "개발") ;

        ///// 다형성을 배열에 적용할 수 있다
        //// 다형성을 사용하는 이유? 
        PersonVO [] perAry = new PersonVO[3] ;
        perAry[0] = stu ;
        perAry[1] = teacher ;
        perAry[2] = manager ;
        /// 이렇게 할 수 있는 이유는 PersonVO가 ManagerVO/TeacherVO/StudentVO/ManagerVO의
        /// 부모 클래스라서 stu, teacher, manager가 자동으로 upcasting 되기 때문에
        
        for (int idx = 0; idx < perAry.length ; idx++) {
            PersonVO per = perAry[idx] ;
            if (per == stu) {
                System.out.println("debug: 여기여기!!!");
                System.out.println(stu.perInfo());
            }
            
            
            // System.out.println(per.stuInfo);  
            // 문제: per.stuInfo()처럼 stuInfo() 메서드를 불러올 수 없다. 부모 클래스는 자식 클래스 메서드에 접근할 수 없어서.
            // 해결 방법: 강제로 형 변환

            // 알 수 없으니까 조건문으로 해결한다
            // 하지만, 조건문으로 해결해도 타입이 매우 많을 때는 해결이 어렵다. 그러나 다형성으로 해결하는데 이건 나중에 배움.


            // instanceof 연산자: 객체 타입을 비교해주는 연산자
            if (per instanceof StudentVO) { //per의 객체 타입이 StudentVO면 
                System.out.println( ((StudentVO)per).stuInfo() ) ; // StudentVO로 형변환해줌
            }

            if (per instanceof TeacherVO) { //per의 객체 타입이 TeacherVO면
                System.out.println( ((TeacherVO)per).teacherInfo() ) ; // TeacherVO로 형변환해줌
            }

            if (per instanceof ManagerVO) {
                System.out.println( ((ManagerVO)per).managerInfo() ) ;
            }
        }

    }

}
