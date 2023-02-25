package com.example.footballers.controllers;

import com.example.footballers.dto.TeamsDto;
import com.example.footballers.services.TeamsService;
import com.example.footballers.services.interfaces.ITeamsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/teams")
public class TeamsController {
    private final ITeamsService _teamsService;

    public TeamsController (ITeamsService teamsService) {
        _teamsService = teamsService;
    }

    @Async
    @GetMapping
    public CompletableFuture<Iterable<TeamsDto>> getAllTeams() {
        return _teamsService.getAllTeams();
    }

    @Async
    @GetMapping("{id}")
    public CompletableFuture<TeamsDto>  getOneTeam(@PathVariable String id) {
        Integer idInt = Integer.valueOf(id);
        return _teamsService.getOneTeams(idInt);
    }
}
