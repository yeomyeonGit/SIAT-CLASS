// - Set (중복 허용 X, 순서 존재 X, 객체를 요소로 갖는다, 가변 길이)
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>() ;
        set.add("jslim") ;
        set.add("siat") ;
        // set.add(1) ;
        // set.add(true) ;
        // set.add(1) ;
        System.out.println(set);   // 원래 주소값이 출력되는 게 맞으나 .toString()이 묵시적으로 붙어 있음
        String [] ary = (String []) (set.toArray()) ;
        // .toArray() 는 Object []를 반환. 그래서 형변환 가능

        
        
    
    }
}