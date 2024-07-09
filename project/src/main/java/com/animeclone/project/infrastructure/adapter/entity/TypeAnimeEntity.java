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
@Table(name = "type_anime_tbl")
public class TypeAnimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_anime_id")
    private long typeAnimeId;
    @Column(name = "anime_type")
    private String animeType;


    @OneToMany(mappedBy = "typeAnime")
    private List<AnimeEntity> animes;
}
