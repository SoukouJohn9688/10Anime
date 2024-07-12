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

    @Mapping(source = "typeLanguage", target = "typeLanguage")
    @Mapping(source = "quality", target = "qualityEnum")
    @Mapping(source = "name", target = "name")
    Episode DTOtoDomain(RequestEpisodeDTO request);

    @InheritInverseConfiguration
    ResponseEpisodeDTO DomainToResponse(Episode episode);

    default List<ResponseEpisodeDTO> toEpisodeResponseList(List<Episode> episodes) {
        return episodes.stream()
                .map(this::DomainToResponse)
                .toList();
    }
}
