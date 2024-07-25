package com.animeclone.project.infrastructure.adapter.repository;

import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Stream;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {



    @Query("SELECT e FROM GenreEntity e WHERE e.genreId IN (:ids)")
    Set<GenreEntity> findAllByGenreIds(@Param("ids") Set<Long> ids);

    default Stream<GenreEntity> streamByIds(Set<Long> ids) {
        return findAllByGenreIds(ids).stream();
    }

}
