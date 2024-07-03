package com.animeclone.project.infrastructure.adapter.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anime_tbl")
public class AnimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //no c donde va el enum
    private enum TypeAnime {
        ACTION,
        DRAMA,
        COMEDY,
        FANTASY
    }

    private LocalDateTime dateAired;
    private float duration;
    private int views;
    private String premiere;
    private String quality;
    private enum status {
        ONAIR
    }
    private String description;
}
