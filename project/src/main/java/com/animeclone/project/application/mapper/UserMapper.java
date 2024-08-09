package com.animeclone.project.application.mapper;


import com.animeclone.project.domain.model.Comments;
import com.animeclone.project.domain.model.User;
import com.animeclone.project.domain.model.dto.Comments.RequestCommentsDTO;
import com.animeclone.project.domain.model.dto.Comments.ResponseCommentsDTO;
import com.animeclone.project.domain.model.dto.user.RequestUserDTO;
import com.animeclone.project.domain.model.dto.user.ResponseUserDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {


    @Mapping(source = "role", target = "role")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "username", target = "username")
    User DTOtoDomain(RequestUserDTO request);

    @InheritInverseConfiguration
    ResponseUserDTO DomainToResponse(User comments);

    default List<ResponseUserDTO> toUserResponseList(List<User> Users) {
        return Users.stream()
                .map(this::DomainToResponse)
                .toList();
    }

}
