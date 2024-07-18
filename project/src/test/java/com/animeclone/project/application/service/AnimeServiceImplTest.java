package com.animeclone.project.application.service;

import com.animeclone.project.application.usecases.AnimeService;
import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.port.AnimePersistencePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AnimeServiceImplTest {

    @Autowired
    private AnimePersistencePort animePersistencePort;

    @Test
    void registerAnime() {

        LocalDateTime fechita=LocalDateTime.now();
        Genre gen1=new Genre(2L,"");
        Genre gen2=new Genre(3L,"");
        Set<Genre> generote=new HashSet<>();
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
        Anime mierda=animePersistencePort.create(anime);
        System.out.println(mierda.toString());
    }
}