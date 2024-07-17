package com.animeclone.project.infrastructure.adapter;

import com.animeclone.project.application.mapper.AnimeMapper;
import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.port.AnimePersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import com.animeclone.project.infrastructure.adapter.exception.AnimeException;
import com.animeclone.project.infrastructure.adapter.mapper.AnimeDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.AnimeRepository;
import com.animeclone.project.infrastructure.adapter.repository.GenreRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class AnimeSpringJpaAdapter implements AnimePersistencePort {

    private final AnimeRepository animeRepository;
    private final AnimeDboMapper animeDboMapper;
    private final GenreRepository genreRepository;


    @Override
    public Anime create(Anime request) {
//        AnimeEntity animeToSave=animeDboMapper.toDbo(request);
//
//        Set<GenreEntity> genres = new HashSet<>(genreRepository.findAllById(
//                animeToSave.getGenres().stream().map(GenreEntity::getGenreId).collect(Collectors.toSet())
//        ));
//
//        animeToSave.setGenres(genres);
//        AnimeEntity animeSaved=animeRepository.save(animeToSave);
//        return animeDboMapper.toDomain(animeSaved);
        AnimeEntity animeToSave = animeDboMapper.toDbo(request);

        // Mapea los IDs de los géneros a las entidades GenreEntity
        Set<Long> genreIds = request.getGenres().stream()
                .map(Genre::getId)
                .collect(Collectors.toSet());

        Set<GenreEntity> genres = new HashSet<>(genreRepository.findAllById(genreIds));

        // Asigna los géneros a la entidad de anime
        animeToSave.setGenres(genres);

        // Guarda la entidad de anime en la base de datos
        AnimeEntity animeSaved = animeRepository.save(animeToSave);

        // Convierte la entidad guardada a dominio
        return animeDboMapper.toDomain(animeSaved);
    }

    @Override
    public Anime getById(Long id) {
        var optionalAnime = animeRepository.findById(id);

        if (optionalAnime.isEmpty()){
            throw new AnimeException(HttpStatus.NOT_FOUND, String.format("Anime no encontrado",id));
        }

        return animeDboMapper.toDomain(optionalAnime.get());
    }

    @Override
    public List<Anime> getAll() {
        List<Anime> listaMapped=animeDboMapper.toAnimeDomainList(animeRepository.findAll());
        return listaMapped;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Anime update(Anime request) {
        return null;
    }

    @Override
    public Anime addGenreToAnime(Anime request) {
        return null;
    }
}
