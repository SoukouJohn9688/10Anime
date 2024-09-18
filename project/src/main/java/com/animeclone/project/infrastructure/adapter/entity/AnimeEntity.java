package com.animeclone.project.infrastructure.adapter.entity;

import com.animeclone.project.domain.enumerations.AnimeTypeEnum;
import com.animeclone.project.domain.enumerations.StatusEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anime_tbl")
public class AnimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_id")
    private long animeId;

    private LocalDateTime dateAired;
    //private LocalDateTime uploadDate;
    private float duration;
    private int views;
    private String premiere;
    private String description;
    private Double score;
    private String name;

    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    @Enumerated(EnumType.STRING)
    private AnimeTypeEnum animeTypeEnum;

    @OneToMany(mappedBy = "animeEntity", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<EpisodeEntity> episodes;

    @ManyToMany(fetch = FetchType.EAGER)
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
