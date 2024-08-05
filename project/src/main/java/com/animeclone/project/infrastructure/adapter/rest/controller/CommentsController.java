package com.animeclone.project.infrastructure.adapter.rest.controller;


import com.animeclone.project.application.usecases.CommentsService;
import com.animeclone.project.domain.model.dto.Comments.RequestCommentsDTO;
import com.animeclone.project.domain.model.dto.Comments.ResponseCommentsDTO;
import com.animeclone.project.infrastructure.adapter.exception.comments.CommentsNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentsController {

    private final CommentsService commentsService;


    @PostMapping("/registry")
    private ResponseCommentsDTO registerComment(@RequestBody RequestCommentsDTO request){

        return commentsService.registerComments(request);
    }

    @PostMapping("{id}")
    private ResponseCommentsDTO editComment(@PathVariable Long id, @RequestBody RequestCommentsDTO request) throws CommentsNotFoundException {

        return commentsService.updateCommentsById(id,request);
    }

    @DeleteMapping("{id}")
    private void deleteComment(@PathVariable Long id){

        commentsService.deleteComments(id);
    }

    @PostMapping("/registry/{episodeId}")
    private ResponseCommentsDTO registerCommentsByEpisodeId(@PathVariable Long episodeId,@RequestBody RequestCommentsDTO request) throws EpisodeNotFoundException, CommentsNotFoundException {

        return commentsService.registerCommentsByEpisodeId(episodeId,request);
    }



}
