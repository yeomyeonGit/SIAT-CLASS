package aapractice.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import aapractice.demo.domain.dto.SampleRequestDTO;
import aapractice.demo.domain.dto.SampleResponseDTO;
import aapractice.demo.domain.entity.JpaSampleEntity;

/*
JPQL- update, delete @Modifying
@Query
*/
@Repository
public interface JpaSampleRepository extends JpaRepository<JpaSampleEntity, String> {
    // select * from JpaSampleEntity where userId = ? and passwd = ?
    public Optional<JpaSampleEntity> findByUserIdAndPasswd(String userId, String passwd) ;
    
    @Modifying
    @Query("UPDATE JpaSampleEntity U " + "SET U.passwd = :passwd , U.name = :name " + "WHERE U.userId = :userId")
    // JPQL에서는 꼭 테이블 별칭을 줘야 함
    public void updateRow(@Param("userId") String userId,
                          @Param("passwd") String passwd,
                          @Param("name") String name) ;

    @Query("SELECT U " + "FROM JpaSampleEntity U")
    public List<JpaSampleEntity> userLst();

    @Query("SELECT new aapractice.demo.domain.dto.SampleResponseDTO(E.userId, E.passwd, E.name) FROM JpaSampleEntity E")
    public List<SampleResponseDTO> findByAll();
} 