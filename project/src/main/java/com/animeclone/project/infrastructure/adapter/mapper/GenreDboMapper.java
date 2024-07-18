package com.animeclone.project.infrastructure.adapter.mapper;


import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface GenreDboMapper {


    @Mapping(source = "genreId", target = "genreId")
    @Mapping(source = "name", target = "name")
    GenreEntity toDbo(Genre domain);

    @InheritInverseConfiguration
    Genre toDomain(GenreEntity entity);

    default Set<GenreEntity> mapToGenreEntities(Set<Genre> genres) {
        return genres.stream()
                .map(genre -> {
                    GenreEntity genreEntity = new GenreEntity();
                    genreEntity.setGenreId(genre.getGenreId());
                    genreEntity.setName(genre.getName());
                    return genreEntity;
                })
                .collect(Collectors.toSet());
    }

    // Se le pasa una lista, ya que el metodo findAll() de JPA devuelve una lista.
    default Set<Genre> mapToGenres(List<GenreEntity> genreEntities) {
        return genreEntities.stream()
                .map(genreEntity -> new Genre(genreEntity.getGenreId(), genreEntity.getName()))
                .collect(Collectors.toSet());
    }

}
