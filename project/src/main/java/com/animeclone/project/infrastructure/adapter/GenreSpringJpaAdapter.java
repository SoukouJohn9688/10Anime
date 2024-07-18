package com.animeclone.project.infrastructure.adapter;

import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.port.GenrePersistencePort;
import com.animeclone.project.infrastructure.adapter.mapper.GenreDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.GenreRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
@Transactional
public class GenreSpringJpaAdapter implements GenrePersistencePort {

    private final GenreRepository genreRepository;
    private final GenreDboMapper genreDboMapper;

    @Override
    public Genre create(Genre request) {
        var genreToSave=genreDboMapper.toDbo(request);
        var genreSaved=genreRepository.save(genreToSave);
        return genreDboMapper.toDomain(genreSaved);
    }

    @Override
    public Set<Genre> getAll() {


        return genreDboMapper.mapToGenres(genreRepository.findAll());
    }
}
