package com.example.demo.pojo;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;



import lombok.Data;

@Data
@Entity
public class WallMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private LocalDateTime date;
    @NotEmpty
    private Long authorId;
}
