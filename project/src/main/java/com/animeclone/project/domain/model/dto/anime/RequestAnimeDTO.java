package com.animeclone.project.domain.model.dto.anime;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.model.dto.genre.GenreDTO;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.Set;


public record RequestAnimeDTO(                              @NotNull
                                                            @NotBlank
                                                            @Size(min = 3,max = 30)String name, LocalDateTime dateAired,
                              @NotNull
                              @Min(1)
                              @Max(30)
                              float duration,
                              @NotNull
                              @Min(1)
                              @Max(40)
                              int views,
                              @NotNull
                              @NotBlank
                              @Size(min = 3,max = 30)
                              String premiere,
                              @NotNull
                              @NotBlank
                              @Size(min = 3,max = 30)
                              String description,
                              @NotNull
                              @Min(1)
                              @Max(10)
                              Double score,
                              Set<GenreDTO> genres) {
}
