package aapractice.demo.domain.dto;

import java.util.ArrayList;
import java.util.List;

import aapractice.demo.domain.entity.JpaSampleEntity;
import aapractice.demo.domain.entity.PostEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SampleResponseDTO {
    
    public SampleResponseDTO(JpaSampleEntity entity) {
        this.userId = entity.getUserId() ;
        this.passwd = entity.getPasswd() ;
        this.name = entity.getName() ;
    }

    // 생성자 오버로딩
    public SampleResponseDTO(String userId, String passwd, String name) {
        this.userId = userId ;
        this.passwd = passwd ;
        this.name = name ;
    }

    private String  userId ;
    private String  passwd ;
    private String  name ;
    private Integer point ;
    private String  refreshToken ;
}
