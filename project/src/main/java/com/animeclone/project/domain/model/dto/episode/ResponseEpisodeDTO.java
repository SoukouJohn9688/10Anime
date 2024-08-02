package com.animeclone.project.domain.model.dto.episode;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.Comments;

import java.util.List;

public record ResponseEpisodeDTO(TypeLanguageEnum typeLanguageEnum, String name, QualityEnum qualityEnum,
                                 List<Comments> comments) {

    public enum TypeLanguageEnum {
        JAPANESE,
        ENGLISH
    }

    public enum QualityEnum{
        MQ720p,
        HQ1080p,
        HQ1440p
    }
}
