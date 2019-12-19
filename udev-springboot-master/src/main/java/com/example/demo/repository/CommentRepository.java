package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import com.example.demo.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    /*JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. So if you don't need
     the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.*/

     @Transactional
     @Modifying
     @Query(value = "update wall_message w set w.content = ?2, w.updated_at = NOW() where w.id = ?1", nativeQuery = true)
     int setFixedContentFor(Long id, String content);
}