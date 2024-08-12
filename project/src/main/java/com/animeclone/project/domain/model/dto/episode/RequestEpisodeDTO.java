package com.animeclone.project.domain.model.dto.episode;

import com.animeclone.project.domain.enumerations.QualityEnum;
import com.animeclone.project.domain.enumerations.TypeLanguageEnum;
import com.animeclone.project.domain.model.Comments;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;

public record RequestEpisodeDTO(Long episodeId,
                                @Enumerated(EnumType.STRING)
                                String typeLanguageEnum,
                                String name,
                                @Enumerated(EnumType.STRING)
                                String qualityEnum,
                                List<Comments> comments) {





}
