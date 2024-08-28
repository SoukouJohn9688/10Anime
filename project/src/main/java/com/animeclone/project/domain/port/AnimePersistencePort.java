package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;

import java.util.List;
import java.util.stream.Stream;

public interface AnimePersistencePort {

    Anime create(Anime request);

    Anime getById(Long id);

    List<Anime> getAll();

    void deleteById(Long id);

    Anime update(Long animeId, Anime request) throws AnimeNotFoundException;

    Anime addGenreToAnime(Anime request);

    public Stream<GenreEntity> streamByIds(List<Long> ids);

    List<Anime> findByName(String name);
    List<Anime> findByGenreName(String genreName);
    List<Anime> findByType(String type);
    Anime getRandomAnime();

    List<Anime> findByYear(int year) throws AnimeNotFoundException;

    List<Anime> getTopToday();

    List<Anime> getTopWeek();

    List<Anime> getTopMonth();
}