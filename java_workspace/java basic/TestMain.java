public class TestMain {
    public static void main(String[] args) {
        // TestDAO dao = new TestDAO() ;

        // dao.test() ;

        // builder pattern으로 생성
        TestDAO dao = TestDAO.builder()
                        .ary(new String[10])
                      .build() ;
        dao.test();
        
    }
    
}
