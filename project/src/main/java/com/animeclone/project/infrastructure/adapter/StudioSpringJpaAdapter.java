package com.animeclone.project.infrastructure.adapter;

import com.animeclone.project.domain.model.Studio;
import com.animeclone.project.domain.port.StudioPersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.StudioEntity;
import com.animeclone.project.infrastructure.adapter.exception.studio.StudioNotFoundException;
import com.animeclone.project.infrastructure.adapter.mapper.StudioDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.StudioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class StudioSpringJpaAdapter implements StudioPersistencePort {

    private final StudioRepository studioRepository;
    private final StudioDboMapper studioDboMapper;

    @Override
    public Studio create(Studio request) {
        var studioToSave=studioDboMapper.toDbo(request);
        var studioSaved= studioRepository.save(studioToSave);
        return studioDboMapper.toDomain(studioSaved);
    }

    @Override
    public List<Studio> getAll() {


        return studioDboMapper.mapToStudios(studioRepository.findAll());
    }

    @Override
    public Studio edit(Long id, Studio request) throws StudioNotFoundException {
        StudioEntity studio = studioDboMapper.toDbo(request);

        Optional<StudioEntity> studiofound = studioRepository.findById(id);


        if (studiofound.isPresent()) {
            studiofound.get().setStudioId(id);
            studiofound.get().setName(studio.getName());
            studioRepository.save(studiofound.get());


        } else if (studiofound.isEmpty()) {
            throw new StudioNotFoundException("El Studio con el id " + id + " no se encontro");
        }
        return request;
    }

    @Override
    public void deleteById(Long id) {
        studioRepository.deleteById(id);
    }


    @Override
    public List<Studio> FindByName(String name) {
        List<StudioEntity> nameGenre = studioRepository.findByNameContainingIgnoreCase(name);
        return studioDboMapper.toStudioDomainList(nameGenre);
    }




}
