package com.animeclone.project.domain.model;

import com.animeclone.project.domain.enumerations.AnimeDubbedEnum;
import com.animeclone.project.domain.enumerations.AnimeTypeEnum;
import com.animeclone.project.domain.enumerations.StatusEnum;
import com.animeclone.project.domain.model.dto.genre.GenreDTO;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@Builder
public class Anime {


    private long id;
    private LocalDateTime dateAired;
    private float duration;
    private int views;
    private String premiere;
    private String description;
    private String name;
    private Double score;
    private List<Genre> genres;
    private List<Episode> episodes;

    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;

    @Enumerated(EnumType.STRING)
    private AnimeTypeEnum animeTypeEnum;

    @Enumerated(EnumType.STRING)
    private AnimeDubbedEnum animeDubbedEnum;






}
