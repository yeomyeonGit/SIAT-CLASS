public class TeacherMain {
    
    public static void main(String[] args) {
        Teacher tea01 = new Teacher();
        System.out.println("teacher address : "+tea01);
        tea01.name = "섭섭해";
        System.out.println("tea01 name = "+tea01.name);
        Teacher tea02 = new Teacher();
        System.out.println("teacher address : "+tea02);
        tea02.name = "임섭순";
        System.out.println("tea02 name = "+tea02.name);
    }
}
