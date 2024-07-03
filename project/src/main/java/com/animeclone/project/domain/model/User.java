package com.animeclone.project.domain.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {

    private long id;
    private String username;
    private String password;
    private String role;
}
