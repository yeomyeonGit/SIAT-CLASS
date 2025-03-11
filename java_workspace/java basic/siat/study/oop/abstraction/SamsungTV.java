package siat.study.oop.abstraction;

public class SamsungTV implements TV {

    @Override   // 클래스 오버라이드
    public void powerOn() {
        System.out.println("Samsung TV powerOn");
    }
    
}
