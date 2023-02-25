package com.example.footballers.services;

import com.example.footballers.dto.TeamsDto;
import com.example.footballers.mappers.interfaces.ITeamsMapper;
import com.example.footballers.models.Teams;
import com.example.footballers.repos.interfaces.ITeamsRepos;
import com.example.footballers.services.interfaces.ITeamsService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.concurrent.CompletableFuture;

@Service
public class TeamsService implements ITeamsService {
    private final ITeamsRepos _teamsRepos;

    public TeamsService(ITeamsRepos teamsRepos) {
        this._teamsRepos = teamsRepos;
    }

    @Async
    public CompletableFuture<Iterable<TeamsDto>> getAllTeams() {
        return CompletableFuture.completedFuture(ITeamsMapper.INSTANCE.toDtoIterable(_teamsRepos.findAll()));
    }

    @Async
    public CompletableFuture<TeamsDto> getOneTeams(Integer id) {
        Teams team = _teamsRepos.findById(id).get();
        return CompletableFuture.completedFuture(ITeamsMapper.INSTANCE.toDto(team));
    }
}
