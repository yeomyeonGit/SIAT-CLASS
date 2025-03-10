import siat.study.oop.domain.constructor.PersonVO;
import siat.study.oop.service.PolyMorphismService;
import siat.study.oop.util.EnumOop;

// 1: 강사,   2: 학생,   3: 매니저
public class PolymorphismMain {
    public static void main(String[] args) {
        
        PolyMorphismService service = new PolyMorphismService() ;
        service.makePerson(EnumOop.TEA, "임정섭", "서울", "JAVA") ;
        service.makePerson(EnumOop.STU, "박신형", "서울", "2018") ;
        service.makePerson(EnumOop.EMP, "이진규", "서울", "교육운영팀") ;
        
        System.out.println(">>> 전체 출력") ;
        PersonVO[] ary = service.getPerson() ;
        for (int idx = 0 ; idx < ary.length ; idx++) {
            PersonVO per = ary[idx] ;
            if (per != null) {
                System.out.println(per.perInfo());
            }
        }     
    }
    
}
