package com.animeclone.project.domain.model.dto.anime;
import java.time.LocalDateTime;


public record RequestAnimeDTO(LocalDateTime dateAired,
                              float duration,
                              int views,
                              String premiere,
                              String quality,
                              String description) {
}
