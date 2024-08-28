package com.animeclone.project.infrastructure.adapter;


import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.domain.port.EpisodePersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import com.animeclone.project.infrastructure.adapter.mapper.EpisodeDboMapper;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
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
        List<EpisodeEntity> listDB=episodeRepository.findAll();
        return episodeDboMapper.toEpisodeDomainList(listDB);
    }

    @Override
    public Episode edit(Long id, Episode request) throws EpisodeNotFoundException {

       EpisodeEntity episode = episodeDboMapper.toDbo(request);

        Optional<EpisodeEntity> episodefound = episodeRepository.findById(id);


        if (episodefound.isPresent()) {
            episodefound.get().setEpisodeId(id);
            episodefound.get().setName(episode.getName());
            episodefound.get().setTypeLanguageEnum(episode.getTypeLanguageEnum());
            episodeRepository.save(episodefound.get());


        } else if (episodefound.isEmpty()) {
            throw new EpisodeNotFoundException("El episodio con el id " + id + " no se encontro");
        }
        return request;
    }

    @Override
    public Episode findById(Long id) {
        return null;
    }

    @Override
    public String register(Long animeId, Episode request) throws AnimeNotFoundException {

        Optional<AnimeEntity> animedb = animeRepository.findById(animeId);
            if (animedb.isEmpty()) {
                throw new AnimeNotFoundException("Anime no encontrado");
            }
            EpisodeEntity episode = episodeDboMapper.toDbo(request);
            episode.setAnimeEntity(animedb.get());
//            episodeRepository.save(episode);

            animedb.get().getEpisodes().add(episode);
           AnimeEntity response= animeRepository.save(animedb.get());
//
//        for (EpisodeEntity ep:response.getEpisodes()){
//            System.out.println(ep);
//        }
            return "Episodio guardado con exito para el Anime con Id: "+animeId;

    }

    @Override
    public void deleteById(Long id) {

    }
}
