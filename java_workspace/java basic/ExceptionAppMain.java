

public class ExceptionAppMain {
    public static void main(String[] args) throws Exception {
        ExceptionApp app = new ExceptionApp();
        app.printAry(new String[] {"1", "2", "3"}) ;
        // String str = null ;

        // try {
        //     str = app.inputStr() ;
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        
        // System.out.println(str);
        
        // }
        
        app.first(-1);
        
    }
}
