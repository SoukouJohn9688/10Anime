package com.animeclone.project.infrastructure.adapter;

import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.port.GenrePersistencePort;
import com.animeclone.project.infrastructure.adapter.exception.genre.GenreNotFoundException;
import com.animeclone.project.infrastructure.adapter.mapper.GenreDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.GenreRepository;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Genre> getAll() {


        return genreDboMapper.mapToGenres(genreRepository.findAll());
    }

    @Override
    public Genre edit(Long id, Genre request) throws GenreNotFoundException {
        GenreEntity genre = genreDboMapper.toDbo(request);

        Optional<GenreEntity> genrefound = genreRepository.findById(id);


        if (genrefound.isPresent()) {
            genrefound.get().setGenreId(id);
            genrefound.get().setName(genre.getName());
           genreRepository.save(genrefound.get());


        } else if (genrefound.isEmpty()) {
            throw new GenreNotFoundException("El genero con el id " + id + " no se encontro");
        }
        return request;
    }

    @Override
    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }


}
