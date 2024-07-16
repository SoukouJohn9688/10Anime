package com.animeclone.project.infrastructure.adapter.mapper;


import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GenreDboMapper {


    @Mapping(source = "id", target = "genreId")
    @Mapping(source = "name", target = "name")
    GenreEntity toDbo(Genre domain);

    @InheritInverseConfiguration
    Genre toDomain(GenreEntity entity);
}
