package com.example.footballers.services.interfaces;

import com.example.footballers.dto.TeamsDto;
import com.example.footballers.models.Teams;

import java.util.Map;

public interface ITeamsService {

    Iterable<TeamsDto> getAllTeams();
    Teams AddNewTeam(TeamsDto dto);
    void DeleteTeamById(Integer id);
}
