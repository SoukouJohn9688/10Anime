package com.animeclone.project.application.mapper;

import com.animeclone.project.domain.model.Comments;
import com.animeclone.project.domain.model.dto.Comments.RequestCommentsDTO;
import com.animeclone.project.domain.model.dto.Comments.ResponseCommentsDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentsMapper {

    @Mapping(source = "content", target = "content")
    Comments DTOtoDomain(RequestCommentsDTO request);

    @InheritInverseConfiguration
    ResponseCommentsDTO DomainToResponse(Comments comments);

    default List<ResponseCommentsDTO> toCommentsResponseList(List<Comments> comments) {
        return comments.stream()
                .map(this::DomainToResponse)
                .toList();
    }
}
