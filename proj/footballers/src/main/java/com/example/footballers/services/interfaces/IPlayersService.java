package com.example.footballers.services.interfaces;

import com.example.footballers.dto.PlayersDto;
import com.example.footballers.models.Players;

import java.util.Map;

public interface IPlayersService {
    Iterable<PlayersDto> getPlayersByTeamId(Integer id);
    Players updatePlayerData(PlayersDto dto);
    Players addPlayerData(PlayersDto dto);
    void deletePlayerData(Integer id);
}
