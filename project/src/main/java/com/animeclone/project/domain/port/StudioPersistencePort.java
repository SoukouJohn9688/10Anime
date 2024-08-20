package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Studio;
import com.animeclone.project.infrastructure.adapter.exception.studio.StudioNotFoundException;

import java.util.List;

public interface StudioPersistencePort {

    Studio create(Studio request);
    List<Studio> getAll();
    Studio edit(Long id, Studio request) throws StudioNotFoundException;
    void deleteById(Long id);
    List<Studio> FindByName(String name);


}
