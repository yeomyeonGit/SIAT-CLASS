package aapractice.demo.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "siat_member_tbl")
@Entity
@Setter
@Getter
@Builder
public class MemberEntity {
    
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long    id ;

    @Id
    private String  email;

    private String  passwd ;

    @Column(name = "refresh_token")
    private String  refreshToken;   // REFRESH 토큰을 담는 컬럼

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // 일대다의 관계
    // Member가 삭제되면 post도 모두 삭제해라
    // 삭제가 되려면 참조관계를 삭제해야 한다.
    // orphanRemoval은 그렇게 참조관계를 수정할 때 사용
    @JoinColumn(name = "member_id")   // PostEntity과 조인할 수 있는 외래키를 지정하라. PostEntity 테이블에 컬럼 추가.
    private List<PostEntity> posts = new ArrayList<>() ;
    // ✅ List<PostEntity> posts
    // 이 필드는 PostEntity 객체들의 리스트이며,
    // 즉, Member 1명이 여러 개의 Post를 가질 수 있다는 일대다 관계를 나타냅니다.

    public void addPost(PostEntity post) {
        posts.add(post) ;
    }

    public Optional<PostEntity> findPost(Long id) {
        System.out.println("debug >>>> member entity findPost posts size "+ posts.size()) ;
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst() ;
    }

    
}
