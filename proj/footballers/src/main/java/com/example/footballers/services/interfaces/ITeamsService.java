package com.example.footballers.services.interfaces;

import com.example.footballers.dto.TeamsDto;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ITeamsService {
    @Async
    CompletableFuture<Iterable<TeamsDto>> getAllTeams();
    @Async
    CompletableFuture<TeamsDto> getOneTeams(Integer id);
}
