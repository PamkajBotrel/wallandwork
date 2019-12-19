package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
public class CommentJSON implements Serializable {
    // Serializable to avoid Cannot serialize redis ERROR !
    private Long id;
    private Long wallMessageId;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;

    private Date createdAt;
    private Date updatedAt;

    private Long authorId; // TO DO replace it by id, and do the mapping WallMessage <-> WallMessageJSON
}