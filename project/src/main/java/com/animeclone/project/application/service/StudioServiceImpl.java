package com.animeclone.project.application.service;


import com.animeclone.project.application.mapper.StudioMapper;
import com.animeclone.project.application.usecases.StudioService;
import com.animeclone.project.domain.model.Studio;
import com.animeclone.project.domain.model.dto.studio.RequestStudioDTO;
import com.animeclone.project.domain.model.dto.studio.ResponseStudioDTO;
import com.animeclone.project.domain.port.StudioPersistencePort;
import com.animeclone.project.infrastructure.adapter.exception.studio.StudioNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudioServiceImpl implements StudioService {


    private final StudioMapper studioMapper;
    private final StudioPersistencePort genrePersistencePort;



    @Override
    public ResponseStudioDTO registerStudio(RequestStudioDTO request) {
        Studio convertDomain=studioMapper.DTOtoDomain(request);
        Studio registeredStudio=genrePersistencePort.create(convertDomain);
        return studioMapper.DomainToResponse(registeredStudio);
    }

    @Override
    public List<ResponseStudioDTO> getStudios() {


        return studioMapper.toStudioResponseList(genrePersistencePort.getAll());
    }


    @Override
    public ResponseStudioDTO edit(Long id, RequestStudioDTO request) throws StudioNotFoundException {
        Studio studio = studioMapper.DTOtoDomain(request);
        Studio genreToPersist = genrePersistencePort.edit(id, studio);
        return studioMapper.DomainToResponse(genreToPersist);

    }

    @Override
    public void deleteById(Long id) {
        genrePersistencePort.deleteById(id);

    }

    @Override
    public List<ResponseStudioDTO> findByName(String name) {
        List<Studio> updateGenre=genrePersistencePort.FindByName(name);
        return studioMapper.toStudioResponseList(updateGenre);

    }


}
