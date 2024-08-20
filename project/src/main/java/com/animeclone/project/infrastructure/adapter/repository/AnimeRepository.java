package com.animeclone.project.infrastructure.adapter.repository;

import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<AnimeEntity, Long> {

    AnimeEntity findByName(String name);

    @Query("SELECT a FROM AnimeEntity a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<AnimeEntity> findByNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT a FROM AnimeEntity a JOIN a.genres g WHERE LOWER(g.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<AnimeEntity> findByGenreNameContainingIgnoreCase(@Param("name") String name);

    //List<AnimeEntity> findByTypeContainingIgnoreCase(String name);

    List<AnimeEntity> findAllByOrderByDateAiredDesc();

    List<AnimeEntity> findAllByStudio_Name(String name);




    }


