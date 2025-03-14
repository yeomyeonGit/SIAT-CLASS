import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import siat.study.oop.domain.constructor.ManagerVO;
import siat.study.oop.domain.constructor.PersonVO;
import siat.study.oop.domain.constructor.StudentVO;
import siat.study.oop.domain.constructor.TeacherVO;

public class OptionalApp {
    public List<String> getStr() {
        return null ;
    }

    public Optional<PersonVO> findById(Long userId) {
        Optional<PersonVO> person = Optional.of(new StudentVO("a", "a", "a")) ;
        return person ;
    }   // Optional은 객체 하나 넘길 때 많이 사용
    public Optional<List<PersonVO>> getUsers() {
        List<PersonVO> list = new ArrayList<>() ;
        list.add(new StudentVO("a", "a", "a")) ;
        list.add(new TeacherVO("a", "a", "a")) ;
        list.add(new ManagerVO("a", "a", "a")) ;
        Optional<List<PersonVO>> persons = Optional.of(list) ;
        return persons ;
    }
    
}
