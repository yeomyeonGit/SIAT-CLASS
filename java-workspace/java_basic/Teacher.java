public class Teacher {
    // 전역변수 선언

    public String name(String name) {
        System.out.println("매개변수 O, 반환값 O");
        return  name + "님, 안녕하세요";
        
    };

    public void height() {
        System.out.println("매개변수 X, 반환값 X");
        System.out.println("키는 마음대로 입력할 수 없습니다.");
    } ; 

    public void age(int age) {
        System.out.println("매개변수 O, 반환값 X");
        System.out.println("만 나이: " + age);
    } ;
    public String bloodtype() {
        System.out.println("매개변수 X, 반환값 O");
        System.out.println("AB형만 표시됩니다");
        return "AB형";
    };
    public String birthplace(String birthplace) {
        System.out.println("매개변수 O, 반환값 O");
        return birthplace + "에 놀러 오세요!" ;
    } ;

    public boolean isMarried(String isMarried){
        System.out.println("매개변수 O, 반환값 O");
        if (isMarried == "Yes") {
            return true;
        } 
        else {
            return false ;
        }
    } ;
    
    // 생성자 : constructor
    // like a method
    // 반환타입 x, 메서드명은 클래스의 이름과 동일
    // [접근지정자] 반환타입 메서드명([매개변수]) { }
    // 메서드처럼 직접적인 호출은 불가
    // 객체 생성시 호출 가능
    // 매개변수를 받지 않는 생성자를 기본생성자(Default Constructor)라고 한다
    public Teacher() { 

    }     // 명시적으로 만든 경우, 없어도 묵시적으로 존재한다
}
