package siat.study.oop.domain.constructor;

public class PersonVO {
    // 공통의 요소
    private String name ;   // private 접근 지정자는 자식이 접근하지 못한다
    private String addr ;

    // 각각의 구체적인 요소
    // private String subject ;
    // private String StuID ;
    // private String dept ;

    public PersonVO() {

    }

    public PersonVO(String name, String addr) {
        this.name = name;
        this.addr = addr;
        // this.subject = subject;
        // StuID = stuID;
        // this.dept = dept;

    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    public String getName() {
        return name;
    }
    public String getAddr() {
        return addr;
    }

    public String perInfo() {
        return "이름: " + this.getName() + "\t 주소 :" + this.getAddr()  ;
    }

    
    
}
