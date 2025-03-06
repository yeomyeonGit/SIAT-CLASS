package siat.study;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    // 멤버(전역)변수
    private String   title ;
    private String   regDate ; 
    private String   writer ;
    private String   content ;
    private String   viewCnt ;
}

