package com.animeclone.project.infrastructure.adapter.rest.controller;

import com.animeclone.project.application.usecases.StudioService;
import com.animeclone.project.domain.model.dto.studio.RequestStudioDTO;
import com.animeclone.project.domain.model.dto.studio.ResponseStudioDTO;
import com.animeclone.project.infrastructure.adapter.exception.studio.StudioNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/studio")
public class StudioController {

    private final StudioService studioService;

    @PostMapping("/registry")
    private ResponseStudioDTO registerGenre(@RequestBody RequestStudioDTO request){

        return studioService.registerStudio(request);
    }

    @GetMapping
    private ResponseEntity<List<ResponseStudioDTO>> getAll(){

        return ResponseEntity.status(HttpStatus.OK)
                .body(studioService.getStudios());

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        studioService.deleteById(id);

    }
    @PostMapping("{id}")
    private ResponseStudioDTO edit(@PathVariable Long id, @RequestBody RequestStudioDTO request) throws StudioNotFoundException {
        return studioService.edit(id,request);
    }

    @GetMapping("/find/{studioName}")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseStudioDTO> getStudioByName(@PathVariable String studioName){
        return studioService.findByName(studioName);
    }

}