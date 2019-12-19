package com.example.demo.helper;

import com.example.demo.pojo.Member;
import com.example.demo.pojo.MemberJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

	public Member mapToMember(MemberJSON memberJSON) {
        Assert.notNull(memberJSON, "The memberJson must not be null");
        Member m = new Member();
        m.setId(memberJSON.getId());
        m.setGroupId(memberJSON.getGroupId()); 
        m.setName(memberJSON.getName());
        m.setEmail(memberJSON.getEmail());
        return m;
	}

	public MemberJSON mapToMember(Member member) {
        Assert.notNull(member, "The member must not be null");
        MemberJSON mJSON = new MemberJSON();
        mJSON.setId(member.getId());
        mJSON.setGroupId(member.getGroupId()); 
        mJSON.setName(member.getName());
        mJSON.setEmail(member.getEmail());
        return mJSON;
    }
    
    public List<MemberJSON> mapToMember(List<Member> memberList) {
        Assert.notNull(memberList, "The memberList must not be null");
        return memberList.stream().map(this::mapToMember).collect(Collectors.toList());
    }

}
