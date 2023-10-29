package com.example.footballers.services;

import com.example.footballers.dto.PlayersDto;
import com.example.footballers.dto.PositionListDto;
import com.example.footballers.mappers.PlayersMapper;
import com.example.footballers.mappers.PositionListMapper;
import com.example.footballers.models.Players;
import com.example.footballers.models.PositionList;
import com.example.footballers.repos.interfaces.IPositionListRepos;
import com.example.footballers.services.interfaces.IPositionsListService;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

@Service
public class PositionsListService implements IPositionsListService {

    private final IPositionListRepos _positionListRepos;

    public PositionsListService(IPositionListRepos positionListRepos) {
        this._positionListRepos = positionListRepos;
    }

    @Override
    public Iterable<PositionListDto> getAllPositionList() {
        return PositionListMapper.toDtoIterable(_positionListRepos.findAll());
    }

    @Override
    public Iterable<PositionListDto> getAllPositionListByTeam(Integer teamId) {
        return PositionListMapper.toDtoIterableByTeam(_positionListRepos.findAll(), teamId);
    }
}
