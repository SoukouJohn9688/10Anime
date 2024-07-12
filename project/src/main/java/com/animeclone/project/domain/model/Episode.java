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
    private enum quality{
        mq720p,
        hq1080p,
        hq1440p
    }
}
