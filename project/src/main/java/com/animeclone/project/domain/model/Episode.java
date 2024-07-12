package com.animeclone.project.domain.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Episode {
    private Integer id;


    private enum TypeLanguageEnum {
        JAPONES,
        INGLES}
    private TypeLanguageEnum typeLanguage;

    private String name;
    private enum qualityEnum{
        mq720p,
        hq1080p,
        hq1440p
    }
    private qualityEnum qualityEnum;
}
