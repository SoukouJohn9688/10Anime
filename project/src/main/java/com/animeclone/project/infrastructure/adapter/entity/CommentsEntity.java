package com.animeclone.project.infrastructure.adapter.entity;

import com.animeclone.project.domain.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Comments_tbl")
public class CommentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_id")
    private long commentsId;
    private String content;


    @ManyToOne
    private UserEntity userEntity;

    @ManyToOne
    private EpisodeEntity episodeEntity;

}

