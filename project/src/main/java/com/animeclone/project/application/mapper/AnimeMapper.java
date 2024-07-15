package com.animeclone.project.application.mapper;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnimeMapper {

    @Mapping(source = "dateAired", target = "dateAired")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "views", target = "views")
    @Mapping(source = "premiere", target = "premiere")
    //@Mapping(source = "quality", target = "quality")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "name", target = "name")
    Anime DTOtoDomain(RequestAnimeDTO request);

    @InheritInverseConfiguration
    ResponseAnimeDTO DomainToResponse(Anime anime);

    default List<ResponseAnimeDTO> toAnimeResponseList(List<Anime> animes) {
        return animes.stream()
                .map(this::DomainToResponse)
                .toList();
    }
}


