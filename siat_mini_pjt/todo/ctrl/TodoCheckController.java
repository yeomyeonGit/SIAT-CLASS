package todo.ctrl;

import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoCheckController {
    private TodoService service ;   // 변수 정의
    public TodoCheckController(TodoService service) {  // 생성자와 함께 데이터를 전달할 객체 생성
        this.service = service ;
    }

    public List<TodoResponseDTO> checkTodo() {
        System.out.println(">>> ctrl checkTodo");
        List<TodoResponseDTO> list = service.selectService() ;
        return list.stream().filter(s -> s.getStatus().equals("Y")).toList() ;
        
    }
}
