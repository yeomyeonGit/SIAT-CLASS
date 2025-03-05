import siat.study.still.StaticApp;

public class StaticAppMain {
    public static void main(String[] args) {
        StaticApp.staticVar = 10 ;
        System.out.println("클래스 소유 변수: " + StaticApp.staticVar);
        StaticApp.staticMethod();

        // StaticApp.nonStaticVar = 20 // 이렇게 하면 error 발생
        // non-static 변수 or 메서드에 접근하려면 직접 객체를 생성해야 함
        StaticApp app = StaticApp.builder()   // 혼자 연습하는 거니까 builder pattern으로 객체 생성
                        .build();

        app.nonStaticVar = 20 ;
        System.out.println(app.nonStaticVar);
    }
    


    
    // 상수에 대한 접근 및 값 변경
    // StaticApp.constVar = 20;   // 상수이기 때문에 새로 할당할 수 없다
}
