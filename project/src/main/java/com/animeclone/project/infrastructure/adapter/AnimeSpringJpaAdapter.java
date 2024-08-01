package com.animeclone.project.infrastructure.adapter;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.port.AnimePersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import com.animeclone.project.infrastructure.adapter.exception.AnimeException;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import com.animeclone.project.infrastructure.adapter.mapper.AnimeDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.AnimeRepository;
import com.animeclone.project.infrastructure.adapter.repository.GenreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@Service
@Transactional
@RequiredArgsConstructor
public class AnimeSpringJpaAdapter implements AnimePersistencePort {

    private final AnimeRepository animeRepository;
    private final AnimeDboMapper animeDboMapper;
    private final GenreRepository genreRepository;

    @Override
    public Anime create(Anime request) {
        AnimeEntity animeToSave = animeDboMapper.toDbo(request);

        List<Long> genreIds = animeToSave.getGenres().stream()
                .map(GenreEntity::getGenreId)
                .toList();

        List<GenreEntity> genres = genreRepository.findAllByGenreIds(genreIds);

//        animeToSave.setGenres(genres);
        animeToSave.setGenres(genres);

//        for (GenreEntity genre : genres) {
//            genre.getAnimes().add(animeToSave);
//        }


        AnimeEntity animeSaved = animeRepository.save(animeToSave);
        return animeDboMapper.toDomain(animeSaved);
    }

    @Override
    public Anime getById(Long id) {
        var optionalAnime = animeRepository.findById(id);
        if (optionalAnime.isEmpty()) {
            throw new AnimeException(HttpStatus.NOT_FOUND, String.format("Anime no encontrado", id));
        }
        return animeDboMapper.toDomain(optionalAnime.get());
    }

    @Override
    public List<Anime> getAll() {
        return animeDboMapper.toAnimeDomainList(animeRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        // Implementation for deleting anime by ID
    }

    @Override
    public Anime update(Long animeId, Anime request) throws AnimeNotFoundException {
        // Implementation for updating anime
        Optional<AnimeEntity> animedb = animeRepository.findById(animeId);
        if (animedb.isEmpty()) {
            throw new AnimeNotFoundException("Anime not found in the database.");
        }

        AnimeEntity animeToUpdate=animeDboMapper.toDbo(request);
        animedb.get().setAnimeId(animeId);
        animedb.get().setGenres(animeToUpdate.getGenres());
        animedb.get().setName(animeToUpdate.getName());
        animedb.get().setDescription(animeToUpdate.getDescription());
        animedb.get().setDuration(animeToUpdate.getDuration());
        animedb.get().setEpisodes(animeToUpdate.getEpisodes());
        animedb.get().setScore(animeToUpdate.getScore());
        animedb.get().setPremiere(animeToUpdate.getPremiere());
        animedb.get().setStudios(animeToUpdate.getStudios());
        animedb.get().setDateAired(animeToUpdate.getDateAired());
        animedb.get().setAnimeTypeEnum(animeToUpdate.getAnimeTypeEnum());
        animedb.get().setStatusEnum(animeToUpdate.getStatusEnum());
        animedb.get().setViews(animeToUpdate.getViews());

        animeRepository.save(animedb.get());
        return animeDboMapper.toDomain(animeToUpdate);
    }

    @Override
    public Anime addGenreToAnime(Anime request) {
        // Implementation for adding genre to anime
        return null;
    }

    @Override
    public Stream<GenreEntity> streamByIds(List<Long> genreIds) {
        return genreRepository.findAllByGenreIds(genreIds).stream();
    }

    @Override
    public Anime FindByName(String name) {
        AnimeEntity nameanime = animeRepository.findByName(name);
        return animeDboMapper.toDomain(nameanime);
    }
}
