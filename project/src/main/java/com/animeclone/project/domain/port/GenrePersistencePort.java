package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.genre.GenreNotFoundException;

import java.util.List;
import java.util.Set;

public interface GenrePersistencePort {
    Genre create(Genre request);
    List<Genre> getAll();
    Genre edit(Long id, Genre request) throws GenreNotFoundException;
    void deleteById(Long id);

}
