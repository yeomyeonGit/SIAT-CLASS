package com.siat.testspring.valid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siat.testspring.valid.domain.entity.TodoEntity;

/*
JPA 지원하는 Repository 인터페이스
- CrudRepository   *
- PaingAndSortingRepository
- JpaRepository
- Repository  *
 */


@Repository
public interface ValidDAO extends JpaRepository<TodoEntity, Integer> {
    
}
