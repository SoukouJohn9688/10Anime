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
    private Long episodeId;
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


    @ManyToOne
    private AnimeEntity animeEntity;


    @OneToMany(mappedBy = "episodeEntity", cascade = CascadeType.ALL)
    private List<CommentsEntity> commentsEntity;




}
