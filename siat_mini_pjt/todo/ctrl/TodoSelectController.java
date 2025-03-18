package todo.ctrl ;

import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoSelectController {

    private TodoService service ;   // 변수 정의

    public TodoSelectController() {  // 생성자와 함께 데이터를 전달할 객체 생성
        
    }
    public TodoSelectController(TodoService service) {

        this.service = service ;    // service 객체 생성
    }

    public List<TodoResponseDTO> selectCntrl() {
        System.out.println(">>> ctrl selectTodo");
        return service.selectService() ;
    }
    
}
