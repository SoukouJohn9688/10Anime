package com.animeclone.project.infrastructure.adapter.entity;

import com.animeclone.project.domain.model.Episode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Episode_tbl")
public class EpisodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id")
    private Integer episodeId;
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


    @ManyToOne
    private AnimeEntity animeEntity;


    @OneToMany(mappedBy = "episodeEntity")
    private List<CommentsEntity> commentsEntity;




}
