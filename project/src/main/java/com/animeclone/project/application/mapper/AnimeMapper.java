package com.animeclone.project.application.mapper;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.dto.AnimeDTO;

public class AnimeMapper {

    public static AnimeDTO toDTO(Anime anime) {
        return new AnimeDTO(
                anime.getDateAired(),
                anime.getDuration(),
                anime.getViews(),
                anime.getPremiere(),
                anime.getQuality(),
                anime.getDescription()

        );
    }

    public static Anime toEntity(AnimeDTO animeDTO) {
        return Anime.builder()
                .dateAired(animeDTO.getDateAired())
                .description(animeDTO.getDescription())
                .duration(animeDTO.getDuration())
                .views(animeDTO.getViews())
                .quality(animeDTO.getQuality())
                .premiere(animeDTO.getPremiere())
                .build();
    }
}
