/* 1교시: 자바에서 변수를 정의하는 방법  */
/*외우기: 엔트리 포인트 - public static void main() {} */

public class VariableApp {
    public static void main(String[] args) {
        // 지역 변수
        int    age = 25 ;
        double height = 163.6 ;
        char   gender = 'F' ;
        String name = "C Mion" ;
        boolean isMarriage = false ; // is로 시작하면 대부분 boolean 타입이다
        System.out.println(age);
        System.out.println(height);
        System.out.println(gender);
        System.out.println(name);
        System.out.println(isMarriage);

        ////////////////////////////////
        
        byte x = 10, y = 0, sum = 0 ;
        sum = (byte)(x + y)  ;     // downcasting 사례
        System.out.println("연산 결과는: " + sum);

        /////////////
        
        // 자바의 캐스팅 연산자: (타입) 변수명 
        
        char charValue = 'A' ;
        char charValue02 = 'B' ;
        System.out.println(charValue);
        System.out.println(charValue + charValue02);   // 연산을 하면 char는 자동으로 int로 형변환 된다
        System.out.println((char)(charValue + charValue02));
        System.out.println((char)97);


    }
    
}
