import siat.study.still.StaticApp;

public class StaticAppMain {

    public static void main(String[] args) {
        StaticApp.staticVar = 10  ;
        System.out.println("클래스 소유 변수 : "+StaticApp.staticVar); 
        StaticApp.staticMethod();
        // error -> 해결
        StaticApp app = new StaticApp();
        app.nonStaticVar = 10  ;
        System.out.println("인스턴스 소유 변수 : "+app.nonStaticVar); 
        app.nonSaticMethod() ; 
        
        // 상수에 대한 접근 및 값 변경
        // StaticApp.constVar = 20 ; 
    }
}
