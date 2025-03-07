import siat.study.oop.domain.builder.ManagerVO;
import siat.study.oop.domain.builder.StudentVO;
import siat.study.oop.domain.builder.TeacherVO;

public class OOPBuilderMain {
    public static void main(String[] args) {
        /*
        @Builder
        @SuperBuilder (상속관계에서 생성자에서 상속받은 필드에 대한 접근)
         */

        StudentVO stu = StudentVO.builder()
                        .name("학생")
                        .addr("강의실")
                        .stuID("나이는 숫자에 불과해~")
                        .build() ;
        
        System.out.println(stu.perInfo());
        System.out.println(stu.stuInfo());

        System.out.println("구분 >>> ");

        ManagerVO manager = ManagerVO.builder()
                        .name("매니저")
                        .addr("사무실")
                        .dept("자영업")
                        .build() ;
        
        System.out.println(manager.perInfo());
        System.out.println(manager.managerInfo());

        System.out.println("구분 >>> ");

        TeacherVO teacher = TeacherVO.builder()
                        .name("선생님")
                        .addr("교무실")
                        .subject("개발")
                        .build() ;
        
        System.out.println(teacher.perInfo());
        System.out.println(teacher.teacherInfo());
        
    }
    
}
