package com.animeclone.project.application.service;

import com.animeclone.project.application.mapper.CommentsMapper;
import com.animeclone.project.application.usecases.CommentsService;
import com.animeclone.project.domain.model.Comments;
import com.animeclone.project.domain.model.dto.Comments.RequestCommentsDTO;
import com.animeclone.project.domain.model.dto.Comments.ResponseCommentsDTO;
import com.animeclone.project.domain.port.CommentsPersistencePort;
import com.animeclone.project.domain.port.EpisodePersistencePort;
import com.animeclone.project.infrastructure.adapter.exception.comments.CommentsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsMapper commentsMapper;
    private final CommentsPersistencePort commentsPersistencePort;
    private final EpisodePersistencePort episodePersistencePort;


    @Override
    public ResponseCommentsDTO registerComments(RequestCommentsDTO request) {
        Comments convertDomain=commentsMapper.DTOtoDomain(request);
        Comments registeredComment=commentsPersistencePort.register(convertDomain);
        return commentsMapper.DomainToResponse(registeredComment);

    }


    @Override
    public ResponseCommentsDTO updateCommentsById(Long episodeId, RequestCommentsDTO request) throws CommentsNotFoundException {
        Comments convertDomain=commentsMapper.DTOtoDomain(request);
        Comments registeredComment=commentsPersistencePort.register(convertDomain);
        return commentsMapper.DomainToResponse(registeredComment);
    }

    @Override
    public void deleteComments(Long Id) {
        commentsPersistencePort.deleteById(Id);
    }

//    @Override
//    public ResponseCommentsDTO registerCommentsByEpisodeId(Long episodeId, RequestCommentsDTO request) {
//        Comments commentDomain = commentsMapper.DTOtoDomain(request);
//       Episode episode = episodePersistencePort.findById(episodeId);
//
//       commentDomain.setEpisode(episode);
//        episode.getComments().add(commentDomain);
//
//        Comments registeredComment = commentsPersistencePort.register(commentDomain);
//        return commentsMapper.DomainToResponse(registeredComment);
//    }

    @Override
    public String registerCommentsByEpisodeId(Long episodeId, RequestCommentsDTO requestCommentsDTO) throws CommentsNotFoundException {

        Comments commentDomain = commentsMapper.DTOtoDomain(requestCommentsDTO);

        String commentToPersist = commentsPersistencePort.registerCommentsByEpisodeId(episodeId, commentDomain);

        return commentToPersist;
    }

}




