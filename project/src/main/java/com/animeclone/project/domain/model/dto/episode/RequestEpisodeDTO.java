package com.animeclone.project.domain.model.dto.episode;

public record RequestEpisodeDTO(TypeLanguage typeLanguage, String name, Quality quality) {

    public enum TypeLanguage {
        JAPONES,
        INGLES
    }

    public enum Quality {
        MQ720P,
        HQ1080P,
        HQ1440P
    }
}
