package com.example.footballers.services.interfaces;

import com.example.footballers.dto.PlayersDto;
import com.example.footballers.models.Players;

import java.util.Map;

public interface IPlayersService {
    Iterable<PlayersDto> getPlayersByTeamId(Integer id);
    Players updatePlayerData(Map<String, Object> dto);
    Players addPlayerData(Map<String, Object> dto);
}
