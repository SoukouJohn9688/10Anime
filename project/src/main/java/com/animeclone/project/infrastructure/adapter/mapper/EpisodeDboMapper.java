package com.animeclone.project.infrastructure.adapter.mapper;

import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EpisodeDboMapper {

    @Mapping(source = "episodeId", target = "episodeId")
    @Mapping(source = "qualityEnum", target = "qualityEnum")
    @Mapping(source = "typeLanguageEnum", target = "typeLanguageEnum")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "anime", target = "animeEntity")
   // @Mapping(source = "comments", target = "commentsEntity")
    EpisodeEntity toDbo(Episode domain);

    @InheritInverseConfiguration
    @Mapping(target = "anime", ignore = true)
    Episode toDomain(EpisodeEntity entity);

    default List<Episode> toEpisodeDomainList(List<EpisodeEntity> episodeListDB) {
        return episodeListDB.stream()
                .map(this::toDomain)
                .toList();
    }
}
