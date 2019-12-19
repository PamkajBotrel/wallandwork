package com.example.demo.repository;

import com.example.demo.pojo.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    /*JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. So if you don't need
     the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.*/
    @Query(value = "SELECT COUNT(*)  FROM Member m WHERE m.email=:readEmail ",nativeQuery=true)
    long findIfMailInDataBase(String readEmail);//1 si il est dedans , 0 sinon.


}


