import java.util.List;

public class TodoSelectController {

    private TodoService service ;   // 변수 정의
    public TodoSelectController() {  // 생성자와 함께 데이터를 전달할 객체 생성
        service = new TodoService() ;
    }

    public List<TodoResponseDTO> selectCntrl() {
        System.out.println(">>> ctrl selectTodo");
        return service.selectService() ;
    }
    
}
