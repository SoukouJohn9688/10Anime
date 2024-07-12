package com.animeclone.project.domain.model;

import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;





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

    private Double score;

    private enum StatusEnum{
        ONGOING,
        COMPLETED,
        HALTED,
        CANCELLED
    }

    private StatusEnum statusEnum;


    private enum AnimeTypeEnum{
        OVA,
        ONA,
        MOVIE,
        TVSERIES,

    }
    private AnimeTypeEnum animeTypeEnum;

}
