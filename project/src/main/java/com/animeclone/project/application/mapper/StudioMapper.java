package com.animeclone.project.application.mapper;

import com.animeclone.project.domain.model.Studio;
import com.animeclone.project.domain.model.dto.studio.RequestStudioDTO;
import com.animeclone.project.domain.model.dto.studio.ResponseStudioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudioMapper {

    @Mapping(source = "name", target = "name")
    Studio DTOtoDomain(RequestStudioDTO request);

    @InheritInverseConfiguration
    ResponseStudioDTO DomainToResponse(Studio studio);

    default List<ResponseStudioDTO> toStudioResponseList(List<Studio> Studio) {
        return Studio.stream()
                .map(this::DomainToResponse)
                .toList();
    }


}
