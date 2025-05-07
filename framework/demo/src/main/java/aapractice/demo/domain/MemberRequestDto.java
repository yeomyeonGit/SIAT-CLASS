package aapractice.demo.domain;

import java.util.List;

import aapractice.demo.domain.entity.PostEntity;
import jakarta.persistence.Column;
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

public class MemberRequestDto {
    private String email, password ;
    
}
