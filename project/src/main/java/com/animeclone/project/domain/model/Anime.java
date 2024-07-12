package com.animeclone.project.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;





@Data
@Getter
@Setter
public class Anime {


    private long id;
    //no c donde va el enum
    private enum TypeAnime {
        ACTION,
        DRAMA,
        COMEDY,
        FANTASY,
        SLICEOFLIFE,
        ROMCOM,
        MARTIALARTS,
        MECHA
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
