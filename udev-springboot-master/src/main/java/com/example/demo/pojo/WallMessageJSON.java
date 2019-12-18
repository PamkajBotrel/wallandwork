package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class WallMessageJSON implements Serializable {
    // Serializable to avoid Cannot serialize redis ERROR !
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private LocalDateTime date;
    @NotEmpty
    private long authorId;
}
