package siat.study.oop.domain.constructor;

public class TeacherVO extends PersonVO {

    private String subject ;

    public TeacherVO() {

    }

    public TeacherVO(String name, String addr, String subject) {
        super.setName(name) ;
        super.setAddr(addr);
        this.setSubject(subject);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public String teacherInfo() {
        return perInfo() + "\t 과목: " + this.getSubject() ;
    }

    
    
}
