package todo.ctrl ;

import java.util.Map;

import todo.model.domain.TodoRequestDTO;
import todo.service.TodoService;

public class TodoUpdateController {
    private TodoService service ;   // 변수 정의
    public TodoUpdateController(TodoService service) {  // 생성자와 함께 데이터를 전달할 객체 생성
        this.service = service ;
    }

    public int updateCntrl(Map<String, Object> map) {
        System.out.println(">>> ctrl updateTodo");
        return service.updateService(map) ;
    }
    
}
