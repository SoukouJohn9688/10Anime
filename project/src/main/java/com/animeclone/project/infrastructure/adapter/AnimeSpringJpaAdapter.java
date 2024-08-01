package com.animeclone.project.infrastructure.adapter;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.port.AnimePersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import com.animeclone.project.infrastructure.adapter.exception.AnimeException;
import com.animeclone.project.infrastructure.adapter.mapper.AnimeDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.AnimeRepository;
import com.animeclone.project.infrastructure.adapter.repository.GenreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
    public Anime update(Anime request) {
        // Implementation for updating anime
        return null;
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
}
