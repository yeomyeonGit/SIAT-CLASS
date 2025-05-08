package aapractice.demo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "siat_jpa_sample_tbl" )
public class JpaSampleEntity {
    @Id  // 기본키 컬럼
    @Column(name = "user_id", length = 50)   // 대체키
    private String userId ;

    @Column(name = "user_passwd", length = 50, nullable = false)
    private String passwd ;

    @Column(name = "user_name", length = 50, nullable = false)
    private String name ;

    @Column(name = "user_point", length = 50)
    private Integer point ;
    
    @Column(name = "user_token")
    private String refreshToken ;
}
