package com.animeclone.project.domain.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Episode {
    private Integer id;


    private enum TypeLanguage {
        JAPONES,
        INGLES}
    private String name;
}
