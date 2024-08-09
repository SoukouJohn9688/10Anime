package com.animeclone.project.infrastructure.adapter;


import com.animeclone.project.domain.model.Comments;
import com.animeclone.project.domain.port.CommentsPersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.CommentsEntity;
import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import com.animeclone.project.infrastructure.adapter.exception.comments.CommentsNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
import com.animeclone.project.infrastructure.adapter.mapper.CommentsDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.CommentsRepository;
import com.animeclone.project.infrastructure.adapter.repository.EpisodeRepository;
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
    private final EpisodeRepository episodeRepository;



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

//    @Override
//    public Comments registerCommentsByEpisodeId(Long episodeId, Comments comment) throws EpisodeNotFoundException {
//          EpisodeEntity episodeEntity = episodeRepository.findById(episodeId)
//                .orElseThrow(() -> new EpisodeNotFoundException("El episodio con el id " + episodeId + " no se encontró"));
//
//
//
//        CommentsEntity commentEntity = commentsDboMapper.toDbo(comment);
//        commentEntity.setEpisodeEntity(episodeEntity);
//        CommentsEntity savedCommentEntity = commentsRepository.save(commentEntity);
//        return commentsDboMapper.toDomain(savedCommentEntity);
//    }

    @Override
    public String registerCommentsByEpisodeId(Long episodeId, Comments request) {

        Optional<EpisodeEntity> episodedb = episodeRepository.findById(episodeId);
        if (episodedb.isEmpty()) {
            throw new IllegalArgumentException("Episodio no encontrado");
        }

        CommentsEntity commentEntity = commentsDboMapper.toDbo(request);
        commentEntity.setEpisodeEntity(episodedb.get());
        episodedb.get().getCommentsEntity().add(commentEntity);
        EpisodeEntity response = episodeRepository.save(episodedb.get());
//               for (CommentsEntity comentario : response.getCommentsEntity()) {
//            System.out.println(comentario);
//        }
           return "Comentario guardado con exito para el Episodio con nombre: "+episodedb.get().getName();
    }


}
