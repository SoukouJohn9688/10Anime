package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.studio.RequestStudioDTO;
import com.animeclone.project.domain.model.dto.studio.ResponseStudioDTO;
import com.animeclone.project.infrastructure.adapter.exception.studio.StudioNotFoundException;

import java.util.List;

public interface StudioService {
    ResponseStudioDTO registerStudio(RequestStudioDTO request);
    List<ResponseStudioDTO> getStudios();
    ResponseStudioDTO edit(Long id, RequestStudioDTO request) throws StudioNotFoundException;
    void deleteById(Long id);
    List<ResponseStudioDTO> findByName(String name);




}
