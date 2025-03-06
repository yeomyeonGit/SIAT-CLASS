public class CarMain {
    public static void main(String[] args) {
        Car car = new Car() ;
        // 인스턴스 소유의 변수에 값을 할당 
        car.maker = "아우디";
        car.model = "A8" ;
        car.price = 1000 ;
        System.out.println(car.maker); 
        
        // 인스턴스 소유의 메서드 호출하기 ?
        car.drive(); 
        String result = car.repaire();
        System.out.println("반환값 출력 : "+result); 
        car.performence("고급휘발류"); 
        result = car.speed(200) ; 
        System.out.println("반환값 출력 : "+result); 
    }
}
