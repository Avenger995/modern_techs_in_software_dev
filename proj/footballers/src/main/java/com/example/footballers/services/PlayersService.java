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

    public Players updatePlayerData(PlayersDto dto) {
        Players player = _playerRepos.findById(dto.getId()).orElse(null);
        if (player != null) {
            player.setAge(dto.getAge());
            player.setName(dto.getName());
            player.setNumber(dto.getNumber());
            player.setImg(SerializationUtils.serialize(dto.getImg()));
            return _playerRepos.save(player);
        }
        return null;
    }

    public Players addPlayerData(PlayersDto dto){
        Players newPlayer = PlayersMapper.toModel(dto);
        _playerRepos.save(newPlayer);
        return null;
    }

    public void deletePlayerData(Integer id) {
        Players player = _playerRepos.findById(id).orElse(null);
        _playerRepos.delete(player);
        return;
    }
}
