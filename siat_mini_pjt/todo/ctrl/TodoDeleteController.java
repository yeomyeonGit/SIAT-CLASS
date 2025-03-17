public class TodoDeleteController {
    private TodoService service ;   // 변수 정의
    public TodoDeleteController() {  // 생성자와 함께 데이터를 전달할 객체 생성
        service = new TodoService() ;
    }

    public int deleteCntrl(int seq) {
        System.out.println(">>> ctrl deleteTodo");
        return service.deleteService(seq) ;
    }
    
}
