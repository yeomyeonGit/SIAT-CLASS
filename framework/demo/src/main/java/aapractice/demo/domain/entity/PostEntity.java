package aapractice.demo.domain.entity;

import aapractice.demo.domain.PostRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
데이터베이스 테이블과 Java 객체 간의 매핑을 도와주는
@Table - 테이블과 entity 이름이 다른 경우
@Entity - 반드시 기본키(@Id) 지정.  Entity 이름이 곧 Table 이름
 */

@Table(name = "siat_post_tbl")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Oracle Version
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,
                    generator = "post_seq_gen")
    @SequenceGenerator(name = "post_seq_gen",
                        sequenceName = "post_seq", 
                        allocationSize = 1)
    private Long    id ;

    private String title ;
    private String content ;

    public void updatePost(PostRequestDto params) {
        this.title = params.getTitle() ;
        this.content = params.getContent() ;
    }


}
