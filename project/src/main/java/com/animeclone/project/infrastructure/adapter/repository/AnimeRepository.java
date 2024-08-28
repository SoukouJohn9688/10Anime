package com.animeclone.project.infrastructure.adapter.repository;

import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<AnimeEntity, Long> {

    AnimeEntity findByName(String name);

    @Query("SELECT a FROM AnimeEntity a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<AnimeEntity> findByNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT a FROM AnimeEntity a JOIN a.genres g WHERE LOWER(g.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<AnimeEntity> findByGenreNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT a FROM AnimeEntity a WHERE YEAR(a.dateAired) = :year")
    List<AnimeEntity> findByYear(@Param("year") int year);

    @Query("SELECT a FROM AnimeEntity a WHERE FUNCTION('DATE', a.dateAired) = CURRENT_DATE ORDER BY a.views DESC")
    List<AnimeEntity> findTopToday();

    @Query("SELECT a FROM AnimeEntity a WHERE a.dateAired BETWEEN :startOfWeek AND :endOfWeek ORDER BY a.views DESC")
    List<AnimeEntity> findTopWeek(@Param("startOfWeek") LocalDateTime startOfWeek, @Param("endOfWeek") LocalDateTime endOfWeek);

    @Query("SELECT a FROM AnimeEntity a WHERE a.dateAired BETWEEN :startOfMonth AND :endOfMonth ORDER BY a.views DESC")
    List<AnimeEntity> findTopMonth(@Param("startOfMonth") LocalDateTime startOfMonth, @Param("endOfMonth") LocalDateTime endOfMonth);

}


