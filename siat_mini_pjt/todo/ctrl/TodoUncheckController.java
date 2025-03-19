package todo.ctrl;

import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoUncheckController {
    private TodoService service ;   // 변수 정의
    public TodoUncheckController(TodoService service) {  // 생성자와 함께 데이터를 전달할 객체 생성
        this.service = service ;
    }

    public List<TodoResponseDTO> uncheckTodo() {
        System.out.println(">>> ctrl uncheckCtrl");
        List<TodoResponseDTO> list = service.selectService() ;
        return list.stream().filter(s -> s.getCheck() == 0).toList() ;
        
    }
    
}
