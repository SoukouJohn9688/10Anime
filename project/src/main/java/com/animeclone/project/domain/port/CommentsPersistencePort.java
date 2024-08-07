package com.animeclone.project.domain.port;

import com.animeclone.project.domain.model.Comments;
import com.animeclone.project.infrastructure.adapter.exception.comments.CommentsNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;

public interface CommentsPersistencePort {
    Comments edit(Long id, Comments request) throws CommentsNotFoundException;

    Comments register(Comments request);

    void deleteById(Long Id);

    Comments registerCommentsByEpisodeId(Long episodeId,Comments comments) throws CommentsNotFoundException;
}
