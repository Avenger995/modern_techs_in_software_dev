package com.example.footballers.services;

import com.example.footballers.dto.TeamsDto;
import com.example.footballers.mappers.TeamsMapper;
import com.example.footballers.models.Teams;
import com.example.footballers.repos.interfaces.ITeamsRepos;
import com.example.footballers.services.interfaces.ITeamsService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class TeamsService implements ITeamsService {
    private final ITeamsRepos _teamsRepos;

    public TeamsService(ITeamsRepos teamsRepos) {
        this._teamsRepos = teamsRepos;
    }


    public Iterable<TeamsDto> getAllTeams() {
        return TeamsMapper.toDtoIterable(_teamsRepos.findAll());
    }

    public Teams AddNewTeam(Map<String, Object> dto) {
        Teams team = TeamsMapper.toModel(dto);
        return _teamsRepos.save(team);
    }

    public void DeleteTeamById(Integer id) {
        _teamsRepos.deleteById(id);
        return;
    }
}
