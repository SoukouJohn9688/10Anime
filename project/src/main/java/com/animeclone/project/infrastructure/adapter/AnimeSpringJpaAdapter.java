package com.animeclone.project.infrastructure.adapter;

import com.animeclone.project.application.mapper.AnimeMapper;
import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.port.AnimePersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.exception.AnimeException;
import com.animeclone.project.infrastructure.adapter.mapper.AnimeDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.AnimeRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class AnimeSpringJpaAdapter implements AnimePersistencePort {

    private final AnimeRepository animeRepository;
    private final AnimeDboMapper animeDboMapper;


    @Override
    public Anime create(Anime request) {
        var animeToSave=animeDboMapper.toDbo(request);
        var animeSaved=animeRepository.save(animeToSave);
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
}
