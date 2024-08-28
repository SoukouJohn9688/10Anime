package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Comments;
import com.animeclone.project.infrastructure.adapter.exception.comments.CommentsNotFoundException;

public interface CommentsPersistencePort {
    Comments edit(Long id, Comments request) throws CommentsNotFoundException;

    Comments register(Comments request);

    void deleteById(Long Id);

    String registerCommentsByEpisodeId(Long episodeId,Comments comments) throws CommentsNotFoundException;
}
