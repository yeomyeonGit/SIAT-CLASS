/* 3교시: 참조 타입과 생성자의 이해 */

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car() ;
        // 오른쪽부터 ) 객체를 생성 -> 변수에 할당 -> 변수의 타입을 클래스와 동일하게 지정

        car.maker = "Mercedes" ;
        car.model = "S-Class Mercedes-Maybach" ;
        car.price = 300000000 ;

        // car 인스턴스의 각 변수에 자료형에 맞는 값 할당

        System.out.println("제조사: " + car.maker);
        System.out.println("차량명: " + car.model);
        System.out.println("판매가: " + car.price);

        // 인스턴스 소유의 메서드 호출하기
        car.drive() ;
        String result = car.repaire() ;  // 반환값이 있을 때는 변수에 넣어서 결과 출력
        System.out.println("반환값 출력: " + result);

        car.performance("디젤") ;

        result = car.speed(200) ;
        // 자료형이 같을 때는 원래 앞에서 정의한 변수를 덮어쓸 수 있다
        System.out.println(result);
    }
    
}
