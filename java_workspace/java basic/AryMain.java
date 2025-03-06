import siat.study.PostDTO;
import siat.study.post.dao.PostDAO;
import siat.study.post.domain.PostResponseDTO;

public class AryMain {

    public static void main(String[] args) {
        /*
        배열(Array)
        - []
        - 고정길이를 갖는다
        - 단일 타입만 담는 그릇
        - 리사이징이되지 않는다
        - length 
        - 참조타입으로 취급
        */    

        

        System.out.println(">>>> 참조타입의 객체를 배열에 담는다면? "); 
        PostDTO dto = PostDTO.builder()
                        .title("제목")
                        .writer("jslim")
                        .regDate("몰라")
                        .content("쉬는시간")
                        .viewCnt("0").build() ; 
        PostDTO [] dtoAry = new PostDTO [10] ; 
        dtoAry[0] = dto ; 
        dtoAry[1] = dto ; 
        dtoAry[2] = dto ; 

        for(PostDTO entity : dtoAry) {
            if( entity != null) {
                System.out.println(entity.getTitle());
            }
            
        }
        ////////////////
        /// Quiz) PostDAO 객체 생성후 selectRow() 메서드 호출 후 출력 
        PostDAO dao = PostDAO.builder().build() ; 
        PostResponseDTO [] responseAry = dao.selectRow() ;
        System.out.println(">>> 게시글 출력"); 
        for(PostResponseDTO entity : responseAry) {
            System.out.println(entity); 
        }
        
        


    }
}
