public class StudentMain {
    public static void main(String[] args) {

        Student stu = new Student() ; 
        stu.name = "박신형";
        stu.gender = 'F' ; 
        System.out.println("당신의 이름은 : "+stu.name);
        System.out.println("당신의 성별은 : "+stu.gender);
    }
}
