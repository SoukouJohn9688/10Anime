package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface AnimePersistencePort {

    Anime create(Anime request);

    Anime getById(Long id);

    List<Anime> getAll();

    void deleteById(Long id);

    Anime update(Anime request);

    Anime addGenreToAnime(Anime request);

    public Stream<GenreEntity> streamByIds(List<Long> ids);
}