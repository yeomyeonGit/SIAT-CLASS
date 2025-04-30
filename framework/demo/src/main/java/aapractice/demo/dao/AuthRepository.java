package aapractice.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aapractice.demo.domain.entity.UserEntity;
import java.util.List;
import java.util.Optional;


// JpaRepository는 인터페이스
// JpaRepositoy라는 api에서 제공하는 crud 메서드를 사용할수도 있고 직접 정의할수도 있다.
@Repository
public interface AuthRepository extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findByEmail(String email);  // select
    public Optional<UserEntity> findByRefreshToken(String token);


    
}