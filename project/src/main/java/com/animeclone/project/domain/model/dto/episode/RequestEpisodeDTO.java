package com.animeclone.project.domain.model.dto.episode;

public record RequestEpisodeDTO(TypeLanguageEnum typeLanguageEnum, String name, QualityEnum qualityEnum) {

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
