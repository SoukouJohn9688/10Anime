package com.animeclone.project.application.mapper;

import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EpisodeMapper {
    @Mapping(source = "episodeId", target = "episodeId")
    @Mapping(source = "typeLanguageEnum", target = "typeLanguageEnum")
    @Mapping(source = "qualityEnum", target = "qualityEnum")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "comments", target = "comments")
    Episode DTOtoDomain(RequestEpisodeDTO request);

    @InheritInverseConfiguration
    ResponseEpisodeDTO DomainToResponse(Episode episode);

    default List<ResponseEpisodeDTO> toEpisodeResponseList(List<Episode> episodes) {
        return episodes.stream()
                .map(this::DomainToResponse)
                .toList();
    }
}
