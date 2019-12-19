package com.example.demo.pojo;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
@Entity
@Table(name="comments")
public class Comment extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "wall_message_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private long wallMessageId;

    @NotEmpty
    private String title;
    
    @NotEmpty
    @Lob
    private String content;
    // @ManyToOne
    // @JoinColumn(name="author_id")
    private Long authorId;
}