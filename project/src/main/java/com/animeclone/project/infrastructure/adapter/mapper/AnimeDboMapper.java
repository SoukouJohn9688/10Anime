package com.animeclone.project.infrastructure.adapter.mapper;


import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnimeDboMapper {
    @Mapping(source = "animeId", target = "id")
    @Mapping(source = "dateAired", target = "dateAired")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "views", target = "views")
    @Mapping(source = "premiere", target = "premiere")
    @Mapping(source = "quality", target = "quality")
    AnimeEntity toDbo(Anime domain);

    @InheritInverseConfiguration
    Anime toDomain(AnimeEntity entity);

}
