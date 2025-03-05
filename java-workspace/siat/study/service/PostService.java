package siat.study.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// @AllArgsConstructor // 멤버변수가 없을 때는 안 써도 됨
@Builder

public class PostService {

    public String savePost() {
        System.out.println("debug >>> service savePost call");
        return "게시글 작성이 완료되었습니다." ;
    }

    public String updatePost() {
        System.out.println("debug >>> service savePost call");
        return "게시글이 수정되었습니다." ;
    }

    public String deletePost() {
        System.out.println("debug >>> service savePost call");
        return "게시글이 삭제되었습니다." ;
    }
}


// service: 비즈니스로직만