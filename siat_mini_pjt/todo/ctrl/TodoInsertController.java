package todo.ctrl ;

import todo.model.domain.TodoRequestDTO;
import todo.service.TodoService;

public class TodoInsertController {
    private TodoService service ;   // 변수 정의
    public TodoInsertController() {  // 생성자와 함께 데이터를 전달할 객체 생성
    }

    public TodoInsertController(TodoService service) {  // 생성자와 함께 데이터를 전달할 객체 생성
        this.service = service ;
    }


    public int insertCtrl(TodoRequestDTO request) {
        System.out.println(">>> ctrl insertCtrl");
        return service.insertService(request) ;
    }
    
}
