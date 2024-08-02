package com.animeclone.project.infrastructure.adapter;


import com.animeclone.project.domain.model.Comments;
import com.animeclone.project.domain.port.CommentsPersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.CommentsEntity;
import com.animeclone.project.infrastructure.adapter.exception.comments.CommentsNotFoundException;
import com.animeclone.project.infrastructure.adapter.mapper.CommentsDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.CommentsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentsSpringJpaAdapter implements CommentsPersistencePort {

    private final CommentsRepository commentsRepository;
    private final CommentsDboMapper commentsDboMapper;


    @Override
    public Comments edit(Long id, Comments request) throws CommentsNotFoundException {
        CommentsEntity comment = commentsDboMapper.toDbo(request);

        Optional<CommentsEntity> commentfound = commentsRepository.findById(id);


        if (commentfound.isPresent()) {
            commentfound.get().setContent(comment.getContent());
            commentsRepository.save(commentfound.get());


        } else if (commentfound.isEmpty()) {
            throw new CommentsNotFoundException("El comentario con el id " + id + " no se encontro");
        }
        return request;
    }

    @Override
    public Comments register(Comments request) {
        var commentToSave= commentsDboMapper.toDbo(request);
        var commentSaved = commentsRepository.save(commentToSave);
        return commentsDboMapper.toDomain(commentSaved);
    }

    @Override
    public void deleteById(Long Id) {
        commentsRepository.deleteById(Id);
    }
}
