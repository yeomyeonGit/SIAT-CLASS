package todo.ctrl;

import java.util.Comparator;
import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoSortController {
    private TodoService service ;   // 변수 정의
    public TodoSortController(TodoService service) {  // 생성자와 함께 데이터를 전달할 객체 생성
        this.service = service ;
    }

    public List<TodoResponseDTO> sortTodo() {
        System.out.println(">>> ctrl uncheckCtrl");
        List<TodoResponseDTO> list = service.selectService() ;
        return list.stream().sorted(Comparator.comparing(TodoResponseDTO::getPriority).reversed()).toList() ;

        //(Comparator.comparing(TodoResponseDTO::getPriority).reversed()).toList()

        // list.stream().sorted(Comparator.reverseOrder()).toList()
        
    }
    
}
