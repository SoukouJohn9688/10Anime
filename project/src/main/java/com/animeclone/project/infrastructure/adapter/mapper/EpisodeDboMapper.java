package com.animeclone.project.infrastructure.adapter.mapper;


import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EpisodeDboMapper {


    @Mapping(source = "episodeId", target = "episodeId")
    //@Mapping(source = "content", target = "content")
    @Mapping(source = "qualityEnum", target = "qualityEnum")
    @Mapping(source = "typeLanguageEnum", target = "typeLanguageEnum")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "anime", target = "animeEntity")
    @Mapping(source = "comments", target = "commentsEntity")
    EpisodeEntity toDbo(Episode domain);

    @InheritInverseConfiguration
    Episode toDomain(EpisodeEntity entity);

}
