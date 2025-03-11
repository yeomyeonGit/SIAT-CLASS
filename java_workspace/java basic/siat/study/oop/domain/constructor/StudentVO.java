package siat.study.oop.domain.constructor;

public class StudentVO extends PersonVO {   // PersonVO 클래스를 상속받는다
    
    private String stuID ;
    public StudentVO() {

    }
    public StudentVO(String name, String addr, String stuID) {
        // super(name, addr) ;  // 부모 클래스
        super.setName(name);
        super.setAddr(addr) ;
        this.setStuID(stuID) ;

    }
    public String getStuID() {
        return stuID;
    }
    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String stuInfo() {   
        return perInfo() + "\t 학번: " + this.getStuID() ;
        // return "이름: " + this.getName() + "\t 주소 :" + this.getAddr() + "\t 학번: " + this.getStuID()  ;
    }

    public String perInfo() {   // 오버라이딩한 상태
        return super.perInfo() + "\t 학번: " + this.getStuID() ;
        // return "이름: " + this.getName() + "\t 주소 :" + this.getAddr() + "\t 학번: " + this.getStuID()  ;
    }


    
}

// PersonVO 클래스 말고 다른 부모 클래스를 상속받을 수 없다: 모호성 문제

