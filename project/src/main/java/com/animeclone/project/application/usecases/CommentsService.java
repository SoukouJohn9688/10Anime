package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.Comments.RequestCommentsDTO;
import com.animeclone.project.domain.model.dto.Comments.ResponseCommentsDTO;
import com.animeclone.project.infrastructure.adapter.exception.comments.CommentsNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;


public interface CommentsService {
    ResponseCommentsDTO registerComments(RequestCommentsDTO request);
    ResponseCommentsDTO updateCommentsById(Long id, RequestCommentsDTO request) throws CommentsNotFoundException;
    void deleteComments(Long Id);
    ResponseCommentsDTO registerCommentsByEpisodeId(Long episodeId ,RequestCommentsDTO request) throws CommentsNotFoundException;
}
