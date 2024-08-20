package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import com.animeclone.project.infrastructure.adapter.entity.StudioEntity;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.studio.StudioNotFoundException;

import java.util.List;
import java.util.stream.Stream;

public interface AnimePersistencePort {

    Anime create(Anime request) throws StudioNotFoundException;

    Anime getById(Long id);

    List<Anime> getAll();

    void deleteById(Long id);

    Anime update(Long animeId, Anime request) throws AnimeNotFoundException;

    Anime addGenreToAnime(Anime request);

    public Stream<GenreEntity> streamByIds(List<Long> ids);

    List<Anime> FindByName(String name);
    List<Anime> FindByGenreName(String genreName);
    List<Anime> FindByType(String type);
    Anime getRandomAnime();
    List<Anime> findAllByOrderByDateAiredDesc();
    List<Anime> FindByStatus(String status);

    List<Anime> FindByDubbed(String dubbed);

    List<Anime> FindByStatusDesc();
    List<Anime> FindByStudio(String studio);


}