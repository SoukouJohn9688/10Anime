package com.animeclone.project.infrastructure.adapter.repository;

import com.animeclone.project.infrastructure.adapter.entity.AnimeEntity;
import com.animeclone.project.infrastructure.adapter.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {
}
