package aapractice.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aapractice.demo.domain.entity.UserEntity;

@Repository
public interface AuthRepository extends JpaRepository<UserEntity, Long> {

    
}