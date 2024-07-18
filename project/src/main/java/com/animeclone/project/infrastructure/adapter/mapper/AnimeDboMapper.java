package com.animeclone.project.infrastructure.adapter.mapper;


import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    @Mapping(source = "genres", target = "genres")
    AnimeEntity toDbo(Anime domain);

    @InheritInverseConfiguration
    Anime toDomain(AnimeEntity entity);



    default Set<Genre> mapToGenres(Set<GenreEntity> genreEntities) {
        return genreEntities.stream()
                .map(genreEntity -> new Genre(genreEntity.getGenreId(), genreEntity.getName()))
                .collect(Collectors.toSet());
    }

    default List<Anime> toAnimeDomainList(List<AnimeEntity> animeListDB) {
        return animeListDB.stream()
                .map(this::toDomain)
                .toList();
    }
}
