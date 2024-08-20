package com.animeclone.project.infrastructure.adapter.entity;

import com.animeclone.project.domain.enumerations.QualityEnum;
import com.animeclone.project.domain.enumerations.TypeLanguageEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Episode_tbl")
public class EpisodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id")
    private Long episodeId;
    private String name;

    @Enumerated(EnumType.STRING)
    private TypeLanguageEnum typeLanguageEnum;

    @Enumerated(EnumType.STRING)
    private QualityEnum qualityEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private AnimeEntity animeEntity;

    @OneToMany(mappedBy = "episodeEntity", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CommentsEntity> commentsEntity;
}
