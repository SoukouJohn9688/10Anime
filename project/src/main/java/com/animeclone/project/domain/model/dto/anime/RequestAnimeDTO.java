package com.animeclone.project.domain.model.dto.anime;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.model.dto.genre.GenreDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;



public record RequestAnimeDTO(
        @NotNull
        @NotBlank
        @Size(min = 3, max = 30)
        String name,

        @NotNull
        LocalDateTime dateAired,

        @NotNull
        @Min(1)
        @Max(30)
        float duration,

        @NotNull
        @Min(0)
        @Max(1000000)
        int views,

        @NotNull
        @NotBlank
        @Size(min = 3, max = 30)
        String premiere,

        @NotNull
        @NotBlank
        @Size(min = 3, max = 100)
        String description,

        @NotNull
        @Min(1)
        @Max(10)
        Double score,

        @NotNull
        @Size(min = 1)
        List<@Valid GenreDTO> genres
) {
}
