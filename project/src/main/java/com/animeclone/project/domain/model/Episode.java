package com.animeclone.project.domain.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Episode {
    private Integer id;
    private String name;

    public enum TypeLanguageEnum {
        JAPANESE,
        ENGLISH}
    public TypeLanguageEnum typeLanguageEnum;


    public enum QualityEnum{
        MQ720p,
        HQ1080p,
        HQ1440p
    }
    public QualityEnum qualityEnum;
}
