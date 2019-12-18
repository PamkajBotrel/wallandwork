package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class MemberJSON implements Serializable {
    // Serializable to avoid Cannot serialize redis ERROR !

    private Long id;
    @NotEmpty
    private String name;

}
