package com.animeclone.project.infrastructure.adapter.repository;

import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<EpisodeEntity, Long> {

}
