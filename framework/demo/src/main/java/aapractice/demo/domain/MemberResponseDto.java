package aapractice.demo.domain;


import java.util.List;

import aapractice.demo.domain.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class MemberResponseDto {
    private Long    id ;

    private String  email;
    private String  passwd ;

    private String  refreshToken;
    private String accessToken ;

    private List<PostResponseDto> posts ;
    
}
