public class TodoReadController {

    private TodoService service ;   // 변수 정의
    public TodoReadController() {  // 생성자와 함께 데이터를 전달할 객체 생성
        service = new TodoService() ;
    }

    public TodoResponseDTO selectTodo(int seq) {
        System.out.println(">>>> TodoReadController selectTodo");
        return service.selectService(seq) ;
    }
    
}
