import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import siat.study.oop.domain.constructor.PersonVO;
import siat.study.oop.domain.constructor.ManagerVO;
import siat.study.oop.domain.constructor.StudentVO;
import siat.study.oop.domain.constructor.TeacherVO;

public class OptionalApp {
    // 1. null 값을 반환하는 메서드 생성
    public List<String []> getStr() {
        return null ;
    }


    // 2. 정보를 검색하는 메서드 findId 만들어 주기
    public Optional<PersonVO> findById(Long userId) {
        Optional<PersonVO> person = Optional.of(new StudentVO("a", "a", "a")) ;
        return person ;

    }
    // 무슨 값을 넣어도 a, a, a, a가 입력된 StudentVO 객체를 반환하는 메서드

    public Optional<List<PersonVO>> getUsers() {
        List<PersonVO> list = new ArrayList<>() ;
        list.add(new StudentVO("a", "a", "a")) ;
        list.add(new TeacherVO("a", "a", "a")) ;
        list.add(new ManagerVO("a", "a", "a")) ;
        Optional<List<PersonVO>> persons = Optional.of(list) ;
        return persons ;
    }
    
}
