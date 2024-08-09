package com.animeclone.project.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Genre_tbl")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private long genreId;
    private String name;
    @ManyToMany(mappedBy = "genres",cascade = CascadeType.DETACH)
    private Set<AnimeEntity> animes;
}
