import siat.study.post.dao.PostDAO;
import siat.study.post.domain.PostRequestDTO;
import siat.study.view.PostView;

public class PostMain {
    public static void main(String[] args) {

        PostView view = PostView.builder()
                            .dao(PostDAO.builder()
                                .requestAry(new PostRequestDTO[10])
                                .build())
                            .build() ; 
        view.menu(); 

        // PostService service = PostService.builder()
        //                         .build() ; 
        // String saveMsg = service.savePost() ; 
        // System.out.println(saveMsg); 
        // String updateMsg = service.updatePost() ; 
        // System.out.println(updateMsg); 
        // String deleteMsg = service.deletePost() ; 
        // System.out.println(deleteMsg); 


    }
}
