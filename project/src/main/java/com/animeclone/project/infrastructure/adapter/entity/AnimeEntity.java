package com.animeclone.project.infrastructure.adapter.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anime_tbl")
public class AnimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_id")
    private long animeId;

    private LocalDateTime dateAired;
    private float duration;
    private int views;
    private String premiere;
    private String quality;
    private String description;

    @OneToMany(mappedBy = "animeentity")
    private List<EpisodeEntity> episodes;

    @OneToOne
    private StatusEntity status;

    @OneToOne
    private ScoreEntity score;

    @ManyToOne
    private TypeAnimeEntity typeAnime;

    @ManyToMany
    @JoinTable(
            name = "anime_genre",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<GenreEntity> genres;


    @ManyToMany
    @JoinTable(
            name = "anime_studio",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<StudioEntity> studios;




}
