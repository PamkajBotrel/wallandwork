package com.example.demo.service;

import com.example.demo.helper.Mapper;
import com.example.demo.pojo.Member;
import com.example.demo.pojo.MemberJSON;
import com.example.demo.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j  //bibliothèque pour les log
@Service
public class MemberService {
    @Resource
    private MemberRepository memberRepository;

    @Resource
    private Mapper mapper;

    public List<MemberJSON> getAllMembers() {
        log.info("Called for getAllMembers ...");
        List<Member> memberList = memberRepository.findAll();
        return mapper.mapToMember(memberList);
    }

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "members", key = "#id")
    public MemberJSON getMemberJSONById(long id) {
        log.info("Called for getMemberJSONById …");
        Member m = memberRepository.getOne(id);
        return mapper.mapToMember(m);
    }

    // public Member getMemberById(long id){
    //     log.info("Called for getMemberById …");
    //     Member m = memberRepository.getOne(id);
    //     return m;
    // }

    public MemberJSON addMember(MemberJSON member) {
        Member m = memberRepository.save(mapper.mapToMember(member));
        return mapper.mapToMember(m);
    }


}
