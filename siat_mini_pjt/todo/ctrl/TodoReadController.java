package todo.ctrl ;

import java.util.Optional;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoReadController {

    private TodoService service ;   // 변수 정의
    public TodoReadController(TodoService service) {  // 생성자와 함께 데이터를 전달할 객체 생성
        this.service = service ;
    }

    public TodoResponseDTO selectTodo(int seq) {
        System.out.println(">>>> TodoReadController selectTodo");
        Optional<TodoResponseDTO> response = service.readDetailService(seq) ;
        if (response.isPresent()) {
            return response.get() ;
        } else {
            return null ;
        }
        
    }
    
}
