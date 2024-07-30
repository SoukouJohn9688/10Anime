package com.animeclone.project.infrastructure.adapter;


import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.domain.port.EpisodePersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import com.animeclone.project.infrastructure.adapter.mapper.EpisodeDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.AnimeRepository;
import com.animeclone.project.infrastructure.adapter.repository.EpisodeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EpisodeSpringJpaAdapter implements EpisodePersistencePort {

    private final EpisodeRepository episodeRepository;
    private final EpisodeDboMapper episodeDboMapper;
    private final AnimeRepository animeRepository;

    @Override
    public List<Episode> findall() {
        return episodeDboMapper.toEpisodeDomainList(episodeRepository.findAll());
    }

    @Override
    public Episode edit(Long id, Episode request) {
        return null;
    }

    @Override
    public Episode findbyid(Long id) {
        return null;
    }

    @Override
    public Episode register(Long animeId,Episode request) {

        Optional<AnimeEntity> animedb = animeRepository.findById(animeId);
            if (animedb.isEmpty()) {
                throw new IllegalArgumentException("Anime no encontrado");
            }
            EpisodeEntity episode = episodeDboMapper.toDbo(request);
//            episode.setAnimeEntity(animedb.get());
            animedb.get().getEpisodes().add(episode);
           AnimeEntity response= animeRepository.save(animedb.get());
       // episodeDboMapper.toDomain(episode);
        for (EpisodeEntity ep:response.getEpisodes()){
            System.out.println(ep);
        }
            return null;

    }

    @Override
    public void deleteById(Long id) {

    }
}
