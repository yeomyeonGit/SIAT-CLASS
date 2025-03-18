package todo.ctrl ;

import todo.model.domain.TodoRequestDTO;
import todo.service.TodoService;

public class TodoUpdateController {
    private TodoService service ;   // 변수 정의
    public TodoUpdateController(TodoService service) {  // 생성자와 함께 데이터를 전달할 객체 생성
        this.service = service ;
    }

    public int updateCntrl(TodoRequestDTO request) {
        System.out.println(">>> ctrl updateTodo");
        return service.updateService(request) ;
    }
    
}
