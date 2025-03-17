public class TodoUpdateController {
    private TodoService service ;   // 변수 정의
    public TodoUpdateController() {  // 생성자와 함께 데이터를 전달할 객체 생성
        service = new TodoService() ;
    }

    public int updateCntrl(TodoRequestDTO request) {
        System.out.println(">>> ctrl updateTodo");
        return service.updateService(request) ;
    }
    
}
