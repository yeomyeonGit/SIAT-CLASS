public class Car {

    // 클래스의 구성요소 
    // 변수 + 메서드 + 생성자

    // 변수 선언 
    // [접근지정자] 자료형 변수명 ;
    // 접근지정자 : public
    
    public String  maker , model ; 
    public int     price ;  

    // 메서드 선언 
    // [접근지정자] 반환타입 메서드명([매개변수]) { } 

    public void drive() {
        System.out.println("매개변수 없고 반환타입이 없다."); 
    }

    public String repaire() {
        System.out.println("매개변수 없고 반환타입이 존재한다."); 
        return "차량이 수리되었습니다." ;  
    } 
    public void performence(String fuel)  {
        System.out.println("매개변수 있고 반환타입이 없다."); 
        System.out.println(fuel+"로 성능향상되었습니다."); 
    }
    public String speed(int speed) {
        System.out.println("매개변수 있고 반환타입이 존재한다.");
        System.out.println("당신의 스피드는 : "+speed);
        return "과속중입니다~~" ;  
    }

}

