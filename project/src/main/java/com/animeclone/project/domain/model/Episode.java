package com.animeclone.project.domain.model;


import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.CommentsEntity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    private Anime anime;

    private List<Comments> comments;



}
