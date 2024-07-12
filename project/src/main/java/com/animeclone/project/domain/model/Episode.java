package com.animeclone.project.domain.model;


import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Episode {
    private Integer id;
    private String name;

    private enum TypeLanguageEnum {
        JAPANESE,
        ENGLISH}
    private TypeLanguageEnum typeLanguageEnum;

    private enum QualityEnum{
        MQ720p,
        HQ1080p,
        HQ1440p
    }

    private QualityEnum qualityEnum;
}
