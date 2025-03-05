public class TeacherMain {
    public static void main(String[] args) {
        
        Teacher tchr = new Teacher();

        tchr.age(27);  // 매개변수 O, 반환값 X
        
        tchr.bloodtype();  // 매개변수 X, 반환값 O

        String result = tchr.name("세모 쿵자토");   // 매개변수 O, 반환값 O
        System.out.println(result);

        tchr.height();   // 키는 마음대로 입력할 수 없습니다.

        boolean cons = tchr.isMarried("No") ;
        System.out.println(cons);


    }
    
}
