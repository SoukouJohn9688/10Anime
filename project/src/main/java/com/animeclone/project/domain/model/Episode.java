package com.animeclone.project.domain.model;


import com.animeclone.project.domain.enumerations.QualityEnum;
import com.animeclone.project.domain.enumerations.TypeLanguageEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class Episode {
    private Long episodeId;
    private String name;

    private Anime anime;

    private List<Comments> comments;

    @Enumerated(EnumType.STRING)
    private TypeLanguageEnum typeLanguageEnum;


    @Enumerated(EnumType.STRING)
    private QualityEnum qualityEnum;

}
