import siat.study.PostDTO;
import siat.study.service.PostService;
import siat.study.view.PostView;

public class PostMain {
    public static void main(String[] args) {
        // PostDTO post = new PostDTO() ;
        /* 
        post.setTitle("너무 배고파요");
        post.setWriter("C Mion");
        post.setContent("살이 쪄버렸어~~");
        post.setRegDate("2025-02-28");
        post.setViewCnt("77");
        */

        
        PostDTO post = PostDTO.builder()
                            .writer("C Mion")   // @setter로 설정
                            .title("졸려")
                            .comment("쉬는 시간이니까 한숨 자자!")
                            .viewCnt("77")
                            .regDate("250228")

                            .build() ;

        System.out.printf("제목: %s, 작성자 %s, 작성일 %s, 조회수 %s, 댓글: %s",
            post.getTitle(),   // 입력한 거 가져오기
            post.getWriter(),
            post.getRegDate(),
            post.getViewCnt(),
            post.getComment()) ;
        
      
        PostView view = PostView.builder()
                        .build() ;
        
        view.menu();
        

        PostService service = PostService.builder()
                            .build();
        
        String saveMsg = service.savePost() ;
        System.out.println(saveMsg);
        String deleteMsg = service.deletePost();
        System.out.println(deleteMsg);
        String updateMsg = service.updatePost();
        System.out.println(updateMsg);

    }
    
}
