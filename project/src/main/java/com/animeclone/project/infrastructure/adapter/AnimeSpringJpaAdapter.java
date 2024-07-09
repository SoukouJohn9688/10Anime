package com.animeclone.project.infrastructure.adapter;

import com.animeclone.project.application.mapper.AnimeMapper;
import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.port.AnimePersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.mapper.AnimeDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.AnimeRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
        AnimeEntity animeToSave=animeDboMapper.toDbo(request);
        var animeSaved=animeRepository.save(animeToSave);
        return animeDboMapper.toDomain(animeSaved);
    }

    @Override
    public Anime getById(Long id) {
        return null;
    }

    @Override
    public List<Anime> getAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Anime update(Anime request) {
        return null;
    }
}
