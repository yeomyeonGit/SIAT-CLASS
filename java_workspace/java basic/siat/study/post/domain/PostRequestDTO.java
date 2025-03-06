package siat.study.post.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostRequestDTO {

    private String title ;
    private String content ;
    private String writer ;       

}
