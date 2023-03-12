package com.example.footballers.services.interfaces;

import com.example.footballers.dto.TeamsDto;
import com.example.footballers.models.Teams;
import org.springframework.scheduling.annotation.Async;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface ITeamsService {

    Iterable<TeamsDto> getAllTeams();
    Teams AddNewTeam(Map<String, Object> dto);
    void DeleteTeamById(int id);
}
