package aapractice.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aapractice.demo.domain.entity.JpaSampleEntity;

@Repository
public interface JpaSampleRepository extends JpaRepository<JpaSampleEntity, String> {
    // select * from JpaSampleEntity where userId = ? and passwd = ?
    public Optional<JpaSampleEntity> findByUserIdAndPasswd(String userId, String passwd) ;
} 