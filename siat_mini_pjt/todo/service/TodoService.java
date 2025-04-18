package todo.service ;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import todo.model.dao.TodoDAO;
import todo.model.dao.TodoOracleDao;
import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class TodoService {
    private TodoOracleDao dao ; // 변수 정의
    public TodoService() {  // 생성자와 함께 데이터를 전달할 객체 생성
        dao = new TodoOracleDao() ;
    }

    public int insertService(TodoRequestDTO request) {
        System.out.println(">>> service insertService");
        return dao.insertRow(request) ;
    }

    public List<TodoResponseDTO> selectService() {
        System.out.println(">>> service selectService");
        return dao.selectRow() ;
    }

    // 삭제
    public int deleteService(int seq) {
        System.out.println(">>> service deleteService");
        return dao.deleteRow(seq) ;
    }

    // 수정
    public int updateService(Map<String, Object> map) {
        System.out.println(">>> service updateService");
        return dao.updateRow(map) ;
    }

    // 전체 보기: 결과를 배열에 담아야 함
    public Optional<TodoResponseDTO> readDetailService(int seq) {
        System.out.println(">>> dao selectService: search all");
        return dao.selectRow(seq) ;
    }

    // 정렬
    public List<TodoResponseDTO> sortService() {
        System.out.println(">>> dao selectService: sort");
        return dao.selectRow() ;
    }
    
    
}
