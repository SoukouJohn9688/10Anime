package com.animeclone.project.infrastructure.adapter.entity;

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

    private Integer animeId;
    private enum TypeLanguage {
        JAPONES,
        INGLES}
    private String name;

    @ManyToOne
    private AnimeEntity animeEntity;


    @OneToMany(mappedBy = "episodeEntity")
    private List<CommentsEntity> commentsEntity;
    private enum quality{
        mq720p,
        hq1080p,
        hq1440p
    }



}
