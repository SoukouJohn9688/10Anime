package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;

import java.util.List;

public interface EpisodePersistencePort {

    List<Episode> findall();

    Episode edit(Long id,Episode request) throws EpisodeNotFoundException;

    Episode findById(Long id);

    Episode register(Long animeId,Episode request);

    void deleteById(Long id);

}
