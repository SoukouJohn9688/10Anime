package com.animeclone.project.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimeDTO {

    private LocalDateTime dateAired;
    private float duration;
    private int views;
    private String premiere;
    private String quality;
    private String description;
}
