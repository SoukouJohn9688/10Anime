package com.animeclone.project.infrastructure.adapter.mapper;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimeDboMapper {
    @Mapping(source = "id", target = "animeId")
    @Mapping(source = "dateAired", target = "dateAired")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "views", target = "views")
    @Mapping(source = "premiere", target = "premiere")
    @Mapping(source = "animeTypeEnum", target = "animeTypeEnum")
    @Mapping(source = "statusEnum", target = "statusEnum")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "genres", target = "genres")
    @Mapping(source = "animeDubbedEnum", target = "animeDubbedEnum")
    AnimeEntity toDbo(Anime domain);

    @InheritInverseConfiguration
    @Mapping(target = "episodes", ignore = true)
    Anime toDomain(AnimeEntity entity);

    default List<Genre> mapToGenres(List<GenreEntity> genreEntities) {
        return genreEntities.stream()
                .map(genreEntity -> new Genre(genreEntity.getGenreId(), genreEntity.getName()))
                .toList();
    }

    default List<Anime> toAnimeDomainList(List<AnimeEntity> animeListDB) {
        return animeListDB.stream()
                .map(this::toDomain)
                .toList();
    }
}
