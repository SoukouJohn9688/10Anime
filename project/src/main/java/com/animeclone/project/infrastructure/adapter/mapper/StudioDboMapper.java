package com.animeclone.project.infrastructure.adapter.mapper;


import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.model.Studio;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import com.animeclone.project.infrastructure.adapter.entity.StudioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface StudioDboMapper {
    //@Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    StudioEntity toDbo(Studio domain);

    @InheritInverseConfiguration
    Studio toDomain(StudioEntity entity);

    default List<Studio> mapToStudios(List<StudioEntity> studioEntities) {
        return studioEntities.stream()
                .map(studioEntity -> new Studio(studioEntity.getStudioId(), studioEntity.getName()))
                .toList();
    }


    default List<Studio> toStudioDomainList(List<StudioEntity> studioListDB) {
        return studioListDB.stream()
                .map(this::toDomain)
                .toList();
    }

}
