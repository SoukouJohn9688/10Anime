package com.animeclone.project.infrastructure.adapter.mapper;


import com.animeclone.project.domain.model.Studio;
import com.animeclone.project.infrastructure.adapter.entity.StudioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface StudioDboMapper {
    @Mapping(source = "id", target = "Id")
    @Mapping(source = "name", target = "name")
    StudioEntity toDbo(Studio domain);

    @InheritInverseConfiguration
    Studio toDomain(StudioEntity entity);
}
