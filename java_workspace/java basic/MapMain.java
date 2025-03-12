import java.util.List;
import java.util.Map;

import siat.study.oop.domain.constructor.ManagerVO;
import siat.study.oop.domain.constructor.StudentVO;
import siat.study.oop.domain.constructor.TeacherVO;

public class MapMain {
    public static void main(String[] args) {
        MapApp app = new MapApp() ;

    Map<String, List> data = app.getMap() ;
    List<StudentVO> stuLst = data.get("stu") ;
    for (StudentVO stu : stuLst) {
        System.out.println(stu.perInfo());
    }

    List<TeacherVO> teaLst = data.get("tea") ;
    for (TeacherVO tea : teaLst) {
        System.out.println(tea.perInfo());
    }
    
    List<ManagerVO> empLst = data.get("emp") ;
    for (ManagerVO emp : empLst) {
        System.out.println(emp.perInfo());
    }

    System.out.println(">>>");
    Map<String, String> dto = app.dtoToMap() ;
    System.out.println(dto.get("id"));
    System.out.println(dto.get("pwd"));
    System.out.println(dto.get("name"));
        
    }

    
    
}
