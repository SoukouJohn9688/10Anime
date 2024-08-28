package com.animeclone.project.infrastructure.adapter;

import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.port.AnimePersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import com.animeclone.project.infrastructure.adapter.mapper.AnimeDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.GenreRepository;
import com.animeclone.project.infrastructure.adapter.exception.AnimeException;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import com.animeclone.project.infrastructure.adapter.repository.AnimeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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
    public List<Anime> findByName(String name) {
        List<AnimeEntity> nameAnime = animeRepository.findByNameContainingIgnoreCase(name);
        return animeDboMapper.toAnimeDomainList(nameAnime);
    }


    @Override
    public List<Anime> findByGenreName(String genreName) {
        List<AnimeEntity> genreNameAnime=animeRepository.findByGenreNameContainingIgnoreCase(genreName);
        return animeDboMapper.toAnimeDomainList(genreNameAnime);
    }


    @Override
    public List<Anime> findByType(String type) {
        //List<AnimeEntity>
        return animeDboMapper.toAnimeDomainList(animeRepository.findAll()
                .stream()
                .filter(ani->ani.getAnimeTypeEnum().name().equals(type)).toList());
    }


    @Override
    public Anime getRandomAnime() {
        List<AnimeEntity> listDB=animeRepository.findAll();
        Random random = new Random();
        Long randomInt = random.nextLong(listDB.size());
        return animeDboMapper.toDomain(animeRepository.findById(randomInt).get());
    }


    @Override
    public List<Anime> findByYear(int year) throws AnimeNotFoundException {

            List<AnimeEntity> listDB=animeRepository.findByYear(year);
            if (listDB.isEmpty()) {
                throw new AnimeNotFoundException("Anime not found in the database.");
            }

        return animeDboMapper.toAnimeDomainList(listDB);
    }


    @Override
    public List<Anime> getTopToday() {
        return animeDboMapper.toAnimeDomainList(animeRepository.findTopToday());
    }

    @Override
    public List<Anime> getTopWeek()
    {
        LocalDateTime weekToday=LocalDateTime.now();
        LocalDateTime weekStart=weekToday.minusDays(7);
        return animeDboMapper.toAnimeDomainList(animeRepository.findTopWeek(weekStart,weekToday));
    }

    @Override
    public List<Anime> getTopMonth() {
        LocalDateTime monthStart=LocalDateTime.now().withDayOfMonth(1);
        LocalDateTime currentDate=LocalDateTime.now();
        LocalDateTime monthEnd=currentDate.with(TemporalAdjusters.lastDayOfMonth());
        return animeDboMapper.toAnimeDomainList(animeRepository.findTopMonth(monthStart,monthEnd));
    }
}
