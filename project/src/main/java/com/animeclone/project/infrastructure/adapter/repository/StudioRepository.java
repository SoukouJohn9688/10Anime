package com.animeclone.project.infrastructure.adapter.repository;

import com.animeclone.project.infrastructure.adapter.entity.GenreEntity;
import com.animeclone.project.infrastructure.adapter.entity.StudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudioRepository extends JpaRepository<StudioEntity, Long> {

    @Query("SELECT a FROM StudioEntity a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<StudioEntity> findByNameContainingIgnoreCase(@Param("name") String name);

}
