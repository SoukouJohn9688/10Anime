package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Anime;

import java.util.List;

public interface AnimePersistencePort {

    Anime create(Anime request);
    Anime getById(Long id);
    List<Anime> getAll();
    void deleteById(Long id);
    Anime update(Anime request);
    Anime addGenreToAnime(Anime request);
}
