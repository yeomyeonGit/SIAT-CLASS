import siat.study.oop.abstraction.LgTV;
import siat.study.oop.abstraction.SamsungTV;
import siat.study.oop.abstraction.TV;
import siat.study.oop.factory.TVFactory;

public class TvAppMain {
    public static void main(String[] args) {

        TVFactory factory = TVFactory.getInstance() ;   // static이라서 바로 클래스 이름으로 메서드에 접근. 메서드는 객체를 생성하는 메서드
        TV tv = factory.getBrand(("lg")) ;
        tv.powerOn();
        
    }
    
}
