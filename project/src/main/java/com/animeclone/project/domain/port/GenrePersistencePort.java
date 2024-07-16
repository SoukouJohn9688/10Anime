package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Genre;

public interface GenrePersistencePort {
    Genre create(Genre request);

}
