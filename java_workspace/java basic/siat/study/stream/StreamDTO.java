package siat.study.stream;

public class StreamDTO {
    private String name ;
    public StreamDTO() {

    }

    public StreamDTO(String name) {
        this.name = name ;

    }
    public String getName() {
        return this.name ;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StreamDTO) {
            return super.equals(((StreamDTO)obj).name);
        }
        return false ;
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name ;
    }
    
}
