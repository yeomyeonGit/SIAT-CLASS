public class TodoInsertController {
    private TodoService service ;   // 변수 정의
    public TodoInsertController() {  // 생성자와 함께 데이터를 전달할 객체 생성
        service = new TodoService() ;
    }

    public int insertCtrl(TodoRequestDTO request) {
        System.out.println(">>> ctrl insertCtrl");
        return service.insertService(request) ;
    }
    
}
