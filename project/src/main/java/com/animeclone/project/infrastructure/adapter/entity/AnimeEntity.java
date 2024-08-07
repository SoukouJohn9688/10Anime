package com.animeclone.project.infrastructure.adapter.entity;


import com.animeclone.project.domain.enumerations.AnimeTypeEnum;
import com.animeclone.project.domain.enumerations.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
    private float duration;
    private int views;
    private String premiere;
    private String description;
    private Double score;
    private String name;

//    public enum StatusEnum{
//        ONGOING,
//        COMPLETED,
//        HALTED,
//        CANCELLED
//    }

    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

//    public enum AnimeTypeEnum{
//        OVA,
//        ONA,
//        MOVIE,
//        TVSERIES,
//
//    }
    @Enumerated(EnumType.STRING)
    private AnimeTypeEnum animeTypeEnum;

    @OneToMany(mappedBy = "animeEntity",cascade = CascadeType.ALL)

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
