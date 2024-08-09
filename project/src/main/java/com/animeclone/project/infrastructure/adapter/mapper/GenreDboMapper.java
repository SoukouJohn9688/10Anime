package com.animeclone.project.infrastructure.adapter.mapper;

import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GenreDboMapper {

    @Mapping(source = "genreId", target = "genreId")
    @Mapping(source = "name", target = "name")
    GenreEntity toDbo(Genre domain);

    @InheritInverseConfiguration
    Genre toDomain(GenreEntity entity);

    default List<GenreEntity> mapToGenreEntities(List<Genre> genres) {
        return genres.stream()
                .map(genre -> {
                    GenreEntity genreEntity = new GenreEntity();
                    genreEntity.setGenreId(genre.getGenreId());
                    genreEntity.setName(genre.getName());
                    return genreEntity;
                })
                .collect(Collectors.toList());
    }

    default List<Genre> mapToGenres(List<GenreEntity> genreEntities) {
        return genreEntities.stream()
                .map(genreEntity -> new Genre(genreEntity.getGenreId(), genreEntity.getName()))
                .toList();
    }
}
