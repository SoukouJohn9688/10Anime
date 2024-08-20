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

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnimeMapper {
    AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    @Mapping(source = "dateAired", target = "dateAired")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "views", target = "views")
    @Mapping(source = "premiere", target = "premiere")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "animeTypeEnum", target = "animeTypeEnum")
    @Mapping(source = "statusEnum", target = "statusEnum")
    @Mapping(source = "genres", target = "genres")
    @Mapping(source = "animeDubbedEnum", target = "animeDubbedEnum")
    @Mapping(source = "studio", target = "studio")
    Anime DTOtoDomain(RequestAnimeDTO request);

    @InheritInverseConfiguration
    ResponseAnimeDTO DomainToResponse(Anime anime);

    default List<Genre> mapToGenres(List<GenreDTO> genres) {
        return genres.stream()
                .map(dto -> new Genre(dto.genreId(), dto.name()))
                .toList();
    }

    default List<GenreDTO> mapToGenreDTOs(List<Genre> genres) {
        return genres.stream()
                .map(genre -> new GenreDTO(genre.getGenreId(), genre.getName()))
                .toList();
    }

    default List<ResponseAnimeDTO> toAnimeResponseList(List<Anime> animes) {
        return animes.stream()
                .map(this::DomainToResponse)
                .toList();
    }
}
