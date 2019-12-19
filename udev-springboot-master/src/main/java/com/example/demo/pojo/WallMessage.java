package com.example.demo.pojo;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
@Entity
@Table(name="wall_message")
public class WallMessage extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    @Lob
    private String content;

    // @ManyToOne
    // @JoinColumn(name="author_id")
    private Long authorId;

}