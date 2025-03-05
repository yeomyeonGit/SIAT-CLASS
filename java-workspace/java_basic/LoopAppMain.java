import siat.study.loop.LoopApp;

public class LoopAppMain {
    public static void main(String[] args) {
        // builder pattern을 통해 객체를 생성하는 방법
        LoopApp loop = LoopApp.builder()
                
                        .build() ;
        
        /*
        int result = loop.sumOneToTen() ;
        System.out.println(result);
         */
        

        
        /*
        int result = loop.sumStarToEndWhile(1, 100) ;
        System.out.println(result);
        */

        // loop.loopBreak(100) ;

        // loop.sumRandom();

        /*
        loop.popStr("LOVE");
        // 파이썬과 달리 자바에서는 .length() 메서드 이용하여 인덱스 접근
        */

        /* 
        loop.gugudanRow();
        // 이중 for문과 비슷. 메서드 안에서 다른 메서드를 호출.
        // 이때 호출된 메서드는 직접적으로 접근되지도, 실행되지도 않으므로 private 설정 => 객체 지향에 적합
        */

        // loop.gugudanTable();

        loop.printIJ();

    }
    
}
