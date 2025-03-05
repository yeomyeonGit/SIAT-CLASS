public class OperatorApp {

    // 생성자: 객체생성시 전역(멤버)변수의 초기화를 도와주는 역할

    public OperatorApp() {
        
    }

    // 반환값 x, 매개변수 x, example01 메서드 정의
    public void example01() {
        System.out.println(">>> 산술연산자 +, -, *, /, %");
        int x = 100, y = 100, result = 0 ;
        System.out.println("+: " +(x+y));
        System.out.println(">>> 증감연산자 ++, --");
        System.out.println("++: " + (++x));
        int number = 20 ;
        result = ++number + 3 ; //전위연산자
        System.out.println("result = "+ result + number);

        System.out.println(">>> 삼항연산자 ++, --");
        String strMsg = (number > 0) ? "양수" : (number == 0) ? "0" : "음수" ;     // 항이 세 개 !!!
        System.out.println(strMsg);

        System.out.println(">>> 논리연산자 &, |, !, &&, ||");
        System.out.println(">>> 관계연산자 >, >=, <, <=, ==, !=");
    }

    public String example02(String str01, String str02) {
      return str01 + "\t" + str02 ;
    }

    // 반환값은 문자열, 매개변수는 정수값 하나를 입력받아서 홀수인지 짝수인지를 판별하는
    // example03 메서드 정의

    public String example03(int number) {
        String answer = (number%2 == 0) ? "짝수" : "홀수" ;
        return answer ;  
    }

    // 반환값은 boolean, 매개변수는 정수값 하나를 입력받아서
    // 입력받은 숫자가 1~100 사이인지를 판단하고 싶다면?
    // example04 메서드 정의

    public boolean example04(int number) {
        boolean result = false ;
        result = (number >= 1 && number <= 100) ? true : false ;
        return result ;
    }
}