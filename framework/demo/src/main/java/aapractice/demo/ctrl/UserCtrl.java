package aapractice.demo.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aapractice.demo.domain.MemberRequestDto;
import aapractice.demo.domain.PostRequestDto;
import aapractice.demo.domain.PostResponseDto;
import aapractice.demo.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/user")
public class UserCtrl {

    @Autowired
    private UserService service ;

    @PostMapping("/usercreate")
    public ResponseEntity<Void> createUser(@RequestBody MemberRequestDto params) {
        System.out.println(("debug >>>> UserCtrl  user/usercreate"));
        service.createUserService(params) ;
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/post")
    public ResponseEntity<PostResponseDto> createPost(@PathVariable(name = "id")String id, @RequestBody PostRequestDto params) {
        System.out.println("debug >>>> UserCtrl createPost");
        PostResponseDto response = service.createPostService(id, params) ;
        return ResponseEntity.ok().body(response) ;
    }

    @GetMapping("/{id}/list")   // 사용자가 작성한 게시글을 전부 가져오는 메서드
    public ResponseEntity getUserPosts(@PathVariable(name = "id")String id) {
        System.out.println("debug >>> UserCtrl geyUsersPosts");
        List<PostResponseDto> lst = service.getUserPostsService(id) ;
        return ResponseEntity.ok().body(lst) ;
    }
    
    
    
    
}
