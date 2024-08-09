package com.animeclone.project.infrastructure.adapter.repository;

import com.animeclone.project.infrastructure.adapter.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {
}
