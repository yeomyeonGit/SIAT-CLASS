package aapractice.demo.domain;

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

public class UserResponseDTO {

    // db set
    private Long    id ;
    
    private String  email ;
    private String  passwd ;
    private String  refreshToken ;

    // code set
    private String  accessToken ;
    
}
