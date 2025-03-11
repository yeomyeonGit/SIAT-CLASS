package siat.study.oop.factory;

import siat.study.oop.abstraction.LgTV;
import siat.study.oop.abstraction.SamsungTV;
import siat.study.oop.abstraction.TV;

public class TVFactory {
    private static TVFactory instance ; // 클래스 소유
    private TV [] ary ;

    private TVFactory() {
        ary = new TV[2] ;
        ary[0] = new SamsungTV() ;
        ary[1] = new LgTV() ;
    }

    public static TVFactory getInstance() {
        if (instance == null) {
            instance = new TVFactory() ;
        }
        return instance ;
    }
    public TV getBrand(String brandName) {
        TV tv = brandName.equals("Samsung") ? ary[0] : ary[1] ;
        return tv ;
    }
    
    
}
