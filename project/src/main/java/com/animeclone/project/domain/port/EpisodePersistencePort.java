package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Episode;

import java.util.List;

public interface EpisodePersistencePort {

    List<Episode> findall();

    Episode findbyid(Long id);

    Episode register(Episode request);

    void deleteById(Long id);

}
