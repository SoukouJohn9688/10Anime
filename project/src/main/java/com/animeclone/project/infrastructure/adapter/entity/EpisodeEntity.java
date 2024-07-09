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
    private AnimeEntity anime;


    @OneToMany(mappedBy = "episodeentity")
    private List<CommentsEntity> comments;


    @ManyToMany
    @JoinTable(
            name = "episode_quality",
            joinColumns = @JoinColumn(name = "quality_id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id")
    )
    private List<QualityEntity> qualitys;

}
