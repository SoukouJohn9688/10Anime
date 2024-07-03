package com.animeclone.project.domain.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Comments {

    private long id;
    private String content;
}
