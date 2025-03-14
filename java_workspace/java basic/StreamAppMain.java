/*
Collection - Java Stream(코드의 가독성, 병렬처리, 유지보수 향상)
Stream 특징
- 원본 데이터 소스를 변경 X 
- 일회용(한번사용하면 재사용 X)
- 작업을 내부 반복으로 처리(forEach - 람다식) 
- 병렬처리 O (Thread) 

*/

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import siat.study.stream.StreamDTO;

public class StreamAppMain {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("jslim", "siat", "it", "java", "python") ; 
        List<String> result = new ArrayList<>();
        System.out.println(">>>> traditional loop"); 
        for(String str : lst) {
            if(str.length() > 4) {
                result.add(str) ;
            }
        }
        System.out.println(">>>> result : "+result);
        System.out.println(">>>> stream API "); 
        lst.stream()
            .filter(str -> str.length() > 4)
            .sorted()
            .forEach(System.out::println);   

        //////////////////////////////////////////////////////
        System.out.println(">>>> Stream 생성"); 
        System.out.println(">>> 배열");
        String [] ary = new String[]{"a","b","c"};
        Stream<String> aryStream = Arrays.stream(ary);
        aryStream.forEach(System.out::println);
        System.out.println(">>> 컬렉션");
        List<String> list = Arrays.asList("a", "b", "c") ;  
        Stream<String> colStream =  list.stream() ; 
        colStream.forEach(System.out::println);
        
        System.out.println(">>> 빌더"); 
        Stream<String> streamBuilder = Stream.<String>builder()
            .add("a").add("b").add("c")
            .build() ; 
        streamBuilder.forEach(System.out::println);
        
        // long cnt = colStream.count() ; 
        // System.out.println("cnt = "+cnt);
        
        System.out.println(">>> 생성 - 가공 - 결과만들기(최종연산)");  
        List<String> li = Arrays.asList("a", "b", "c") ;  
        long cnt = li.stream()
            .filter(str -> str.contains("a"))
            .map(str -> str.toUpperCase() )
            .peek(System.out::println)
            .count() ; 
        System.out.println(cnt); 
        ////////
        System.out.println(">>> 객체를 담아서 처리하는 방법 "); 
        Stream<File> fileStream = Stream.of(  new File("siat.txt"), 
                    new File("java.txt"), 
                    new File("jslim.txt"),
                    new File("siat.txt"));

        // fileStream.map( file -> file.getName() )
        fileStream.map(File::getName)
                    .distinct()
                    .sorted(Comparator.reverseOrder())
                    .forEach(System.out::println);

        System.out.println(">>> StreamDTO ");
        List<StreamDTO> l = new ArrayList<>();
        l.add(new StreamDTO("jslim"));
        l.add(new StreamDTO("siat"));
        l.add(new StreamDTO("jslim"));

        int s = l.stream()
            .distinct()
            .peek(System.out::println)
            .collect(Collectors.toList())
            .size() ;
        System.out.println(s); 
    }
}
