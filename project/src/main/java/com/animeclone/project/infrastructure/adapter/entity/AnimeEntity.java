package com.animeclone.project.infrastructure.adapter.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
    private String description;
    private Double score;
    private String name;

    public enum StatusEnum{
        ONGOING,
        COMPLETED,
        HALTED,
        CANCELLED
    }

    public StatusEnum statusEnum;

    public enum AnimeTypeEnum{
        OVA,
        ONA,
        MOVIE,
        TVSERIES,

    }
    public AnimeTypeEnum animeTypeEnum;

    @OneToMany(mappedBy = "animeEntity")
    private List<EpisodeEntity> episodes;



//    @OneToOne
//    private ScoreEntity score;

//    @ManyToOne
//    private TypeAnimeEntity typeAnime;

    @ManyToMany
    @JoinTable(
            name = "anime_genre",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<GenreEntity> genres;


    @ManyToMany
    @JoinTable(
            name = "anime_studio",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<StudioEntity> studios;




}
