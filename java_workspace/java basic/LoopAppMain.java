import siat.study.loop.LoopApp;

public class LoopAppMain {
    public static void main(String[] args) {
        LoopApp app = LoopApp.builder()
                        .build() ; 
        
        // int result = app.sumOneToTen() ; 
        // System.out.println(result); 

        // String result = app.sumStartToEnd(1, 100) ; 
        // System.out.println(result); 

        // String result = app.sumStartToEndDoWhile(1, 100) ; 
        // System.out.println(result); 

        // app.loopBreak(100);

        // app.sumRandom();

        // app.popStr("jslim");

        // app.gugudanRow();

        // app.gugudanTables();

        app.printIJ();
    }
}
