package com.example.footballers.services.interfaces;

import com.example.footballers.dto.TeamsDto;
import com.example.footballers.models.Teams;

import java.util.Map;

public interface ITeamsService {

    Iterable<TeamsDto> getAllTeams();
    Teams AddNewTeam(Map<String, Object> dto);
    void DeleteTeamById(Integer id);
}
