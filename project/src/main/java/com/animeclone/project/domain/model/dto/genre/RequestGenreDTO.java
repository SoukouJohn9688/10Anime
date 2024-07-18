package com.animeclone.project.domain.model.dto.genre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RequestGenreDTO(@NotNull
                              @NotBlank
                              @Size(min = 3,max = 30)String name) {
}
