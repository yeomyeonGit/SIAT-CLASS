package siat.study.oop.service;

import siat.study.oop.domain.constructor.PersonVO ;
import siat.study.oop.domain.constructor.TeacherVO ;
import siat.study.oop.util.EnumOop;
import siat.study.oop.domain.constructor.StudentVO ;
import siat.study.oop.domain.constructor.ManagerVO ;

/*
역할
- 객체 생성(Stu, Tea, Man)을 담당하고
- 생성된 객체를 배열에 관리하고
- 사용자의 요청에 따른 업무 로직을 수행

 */


public class PolyMorphismService {

    private PersonVO [] perAry ;
    private int idx ;

    public PolyMorphismService() {
        perAry = new PersonVO[10] ;
    }

    /*
    - 매개변수로 입력된 division 값에 따라서 생성할 객체 타입이 달라진다.
    - 생성된 객체는 배열에 담는다.
     */

    public void makePerson(EnumOop division, String name, String addr, String comm) {
        switch (division.getDivision()) {
            case "강사":
                TeacherVO tea = new TeacherVO(name, addr, comm) ;
                setPerson(tea);
                break;
            case "학생":
                StudentVO stu = new StudentVO(name, addr, comm) ;
                setPerson(stu);
                break;
            
            case "매니저":
                ManagerVO emp = new ManagerVO(name, addr, comm) ;
                setPerson(emp);
                break;      
        }        
    }

    public void setPerson(PersonVO stu) {
        perAry[idx++] = stu ;
    }

    public PersonVO[] getPerson() {
        return perAry ;
    }

}
