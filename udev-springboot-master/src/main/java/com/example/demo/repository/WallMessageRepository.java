package com.example.demo.repository;

import com.example.demo.pojo.WallMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WallMessageRepository extends JpaRepository<WallMessage, Long> {
    /*JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. So if you don't need
     the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.*/
}
