package com.example.footballers.services;

import com.example.footballers.dto.PlayersDto;
import com.example.footballers.mappers.PlayersMapper;
import com.example.footballers.models.Players;
import com.example.footballers.repos.interfaces.IPlayerRepos;
import com.example.footballers.services.interfaces.IPlayersService;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.util.Map;
import java.util.Optional;

@Service
public class PlayersService implements IPlayersService {
    private final IPlayerRepos _playerRepos;

    public PlayersService(IPlayerRepos playerRepos) {
        this._playerRepos = playerRepos;
    }

    public Iterable<PlayersDto> getPlayersByTeamId(Integer id){
        return PlayersMapper.toDtoIterable(_playerRepos.findAll());
    }

    public Players updatePlayerData(Map<String, Object> dto) {
        Players player = _playerRepos.findById((Integer)dto.get("id")).orElse(null);
        if (player != null) {
            player.setAge(Integer.parseInt((String)dto.get("age")));
            player.setName((String)dto.get("name"));
            player.setNumber(Integer.parseInt((String)dto.get("number")));
            player.setImg(SerializationUtils.serialize(dto.get("img")));
            return _playerRepos.save(player);
        }
        return null;
    }

    public Players addPlayerData(Map<String, Object> dto){
        Players newPlayer = PlayersMapper.toModel(dto);
        _playerRepos.save(newPlayer);
        return null;
    }
}
