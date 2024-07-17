package com.animeclone.project.application.mapper;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.domain.model.dto.genre.GenreDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnimeMapper {
    AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    @Mapping(source = "dateAired", target = "dateAired")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "views", target = "views")
    @Mapping(source = "premiere", target = "premiere")
    //@Mapping(source = "quality", target = "quality")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "genres", target = "genres")
    Anime DTOtoDomain(RequestAnimeDTO request);



    @InheritInverseConfiguration
    ResponseAnimeDTO DomainToResponse(Anime anime);

    default Set<Genre> mapToGenres(Set<GenreDTO> genres) {
        return genres.stream()
                .map(dto -> new Genre(dto.id(),dto.name()))
                .collect(Collectors.toSet());
    }
    default Set<GenreDTO> mapToGenreDTOs(Set<Genre> genres) {
        return genres.stream()
                .map(genre -> new GenreDTO(genre.getId(), genre.getName()))
                .collect(Collectors.toSet());
    }


    default List<ResponseAnimeDTO> toAnimeResponseList(List<Anime> animes) {
        return animes.stream()
                .map(this::DomainToResponse)
                .toList();
    }
}


