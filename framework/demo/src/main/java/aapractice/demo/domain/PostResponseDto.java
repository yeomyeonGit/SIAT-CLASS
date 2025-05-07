package aapractice.demo.domain;

import aapractice.demo.domain.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Setter
@Getter
@ToString
@RequiredArgsConstructor     //인자가 final인 스페셜 생성자를 생성
public class PostResponseDto {
    public PostResponseDto(PostEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent() ;
    }
    
    private Long    id ;

    private String title ;
    private String content ;
    
}
