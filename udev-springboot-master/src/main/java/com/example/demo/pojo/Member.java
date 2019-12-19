package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long groupId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;

}
