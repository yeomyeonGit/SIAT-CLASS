package siat.study.post.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostResponseDTO {
    private String          title ;
    private String          content ;
    private String          writer ;       
    private LocalDateTime   regDate ; 
    private int             viewCnt ;
}
