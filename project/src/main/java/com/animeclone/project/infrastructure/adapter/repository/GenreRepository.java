package com.animeclone.project.infrastructure.adapter.repository;

import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {



    @Query("SELECT e FROM GenreEntity e WHERE e.genreId IN (:ids)")
    List<GenreEntity> findAllByGenreIds(@Param("ids") List<Long> ids);

    default Stream<GenreEntity> streamByIds(List<Long> ids) {
        return findAllByGenreIds(ids).stream();
    }

}
