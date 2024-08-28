package com.animeclone.project.application.service;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.port.AnimePersistencePort;
import com.animeclone.project.domain.port.GenrePersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import com.animeclone.project.infrastructure.adapter.repository.GenreRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.*;


@SpringBootTest
@ActiveProfiles("test")
class AnimeServiceImplTest {

    @Autowired
    private AnimePersistencePort animePersistencePort;
    @Autowired
    private GenrePersistencePort genrePersistencePort;
    @Autowired
    private GenreRepository genreRepository;

    @Test
    @Transactional
    void registerAnime() {

        LocalDateTime fechita=LocalDateTime.now();
        Genre gen1=new Genre(2L,"caca");
        Genre gen2=new Genre(3L,"popo");
        genrePersistencePort.create(gen1);
        genrePersistencePort.create(gen2);
        List<Genre> generote=new ArrayList<>();

        generote.add(gen1);
        generote.add(gen2);

        Anime anime=Anime.builder()
                .premiere("asdfasd")
                .views(1000)
                .score(4.2)
                .duration(23.4f)
                .dateAired(fechita)
                .description("Asdfasdfasd")
                .genres(generote)
                .build();


        System.out.println(create(anime).toString());
    }

    public AnimeEntity create(Anime request) {

        List<GenreEntity> generos= request.getGenres().stream()
                .map((genero)->toGenreEntity(genero)).toList();

        AnimeEntity animeToSave = AnimeEntity.builder()
                .animeTypeEnum(AnimeEntity.)
                .name(request.getName())
                .duration(request.getDuration())
                .score(request.getScore())
                .dateAired(request.getDateAired())
                .description(request.getDescription())
                .genres(generos)
                .views(request.getViews())
                .premiere(request.getPremiere())
                .build();

        List<Long> genreIds = animeToSave.getGenres().stream()
                .map(GenreEntity::getGenreId)
                .toList();

        List<GenreEntity> genres = genreRepository.findAllByGenreIds(genreIds);
//        animeToSave.setGenres(genres);
        animeToSave.setGenres(genres);
//        for (GenreEntity genre : genres) {
//            genre.getAnimes().add(animeToSave);
//        }


        return animeToSave;

    }

    public static Genre toGenre(GenreEntity genreEntity) {
        if (genreEntity == null) {
            return null;
        }
        Genre genre = new Genre();
        genre.setGenreId(genreEntity.getGenreId());
        genre.setName(genreEntity.getName());
        return genre;
    }

    public static GenreEntity toGenreEntity(Genre genre) {
        if (genre == null) {
            return null;
        }
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setGenreId(genre.getGenreId());
        genreEntity.setName(genre.getName());
        return genreEntity;
    }

}