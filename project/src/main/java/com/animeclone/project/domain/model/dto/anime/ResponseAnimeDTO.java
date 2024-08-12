package com.animeclone.project.domain.model.dto.anime;

import com.animeclone.project.domain.model.dto.genre.GenreDTO;

import java.time.LocalDateTime;
import java.util.Set;

public record ResponseAnimeDTO(String name, LocalDateTime dateAired,
                               float duration,
                               int views,
                               String premiere,
                               String description,
                               Double score,
                               String animeTypeEnum,
                               String statusEnum,
                               String animeDubbedEnum,
                               Set<GenreDTO> genres) {
}
