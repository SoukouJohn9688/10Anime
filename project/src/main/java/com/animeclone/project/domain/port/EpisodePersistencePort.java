package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;

import java.util.List;

public interface EpisodePersistencePort {

    List<Episode> findall();

    Episode edit(Long id,Episode request);

    Episode findbyid(Long id);

    String register(Long animeId, Episode request) throws AnimeNotFoundException;

    void deleteById(Long id);

}
