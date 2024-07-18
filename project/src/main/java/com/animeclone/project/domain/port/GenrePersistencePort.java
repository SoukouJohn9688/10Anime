package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Genre;

import java.util.Set;

public interface GenrePersistencePort {
    Genre create(Genre request);
    Set<Genre> getAll();

}
