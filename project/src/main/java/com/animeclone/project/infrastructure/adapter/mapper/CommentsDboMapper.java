package com.animeclone.project.infrastructure.adapter.mapper;

import com.animeclone.project.domain.model.Comments;
import com.animeclone.project.infrastructure.adapter.entity.CommentsEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CommentsDboMapper {

    @Mapping(source = "id", target = "commentsId")
    @Mapping(source = "content", target = "content")
    CommentsEntity toDbo(Comments domain);

    @InheritInverseConfiguration
    Comments toDomain(CommentsEntity entity);

}
