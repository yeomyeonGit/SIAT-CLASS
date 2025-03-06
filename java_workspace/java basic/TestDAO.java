import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor

public class TestDAO {
    private String [] ary ;

    // 객체생성시 호출되는 메서드로 멤버 변수를 초기화하는 역할
    public TestDAO() {
        ary = new String[10] ; // new String[]{"a", "b", "c"} 데이터를 초기화

    }
    public void test() {
        ary[0] = "siat" ;
        System.out.println(ary[0]);
    }
    
}
