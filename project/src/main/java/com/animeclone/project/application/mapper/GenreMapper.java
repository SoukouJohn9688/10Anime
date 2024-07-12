package com.animeclone.project.application.mapper;


import com.animeclone.project.domain.model.Comments;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.model.dto.Comments.RequestCommentsDTO;
import com.animeclone.project.domain.model.dto.Comments.ResponseCommentsDTO;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GenreMapper {

    @Mapping(source = "name", target = "name")
    Genre DTOtoDomain(RequestGenreDTO request);

    @InheritInverseConfiguration
    ResponseGenreDTO DomainToResponse(Genre comments);

    default List<ResponseGenreDTO> toGenresResponseList(List<Genre> Genres) {
        return Genres.stream()
                .map(this::DomainToResponse)
                .toList();
    }



}
