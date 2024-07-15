package com.animeclone.project.infrastructure.adapter.mapper;


import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
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
    AnimeEntity toDbo(Anime domain);

    @InheritInverseConfiguration
    Anime toDomain(AnimeEntity entity);

    default List<Anime> toAnimeDomainList(List<AnimeEntity> animeListDB) {
        return animeListDB.stream()
                .map(this::toDomain)
                .toList();
    }
}
