package com.example.footballers.mappers;

import com.example.footballers.dto.PlayersDto;
import com.example.footballers.models.Players;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PlayersMapper {
    PlayersMapper INSTANCE = Mappers.getMapper(PlayersMapper.class);

    @Named("modelToDtoIterable")
    public static List<PlayersDto> toDtoIterable(List<Players> players){
        ArrayList<PlayersDto> dtos = new ArrayList<>();
        for (Players player: players) {
            PlayersDto dto = new PlayersDto();
            dto.setId(player.getId());
            dto.setName(player.getName());
            dto.setNumber(player.getNumber());
            dto.setAge(player.getAge());
            dto.setImg(SerializationUtils.deserialize(player.getImg()));
            dtos.add(dto);
        }
        return dtos;
    }

    @Named("dtoToModel")
    public static Players toModel(PlayersDto dto) {
        Players player = new Players();
        byte[] img = SerializationUtils.serialize(dto.getImg());
        player.setAge(dto.getAge());
        player.setName(dto.getName());
        player.setNumber(dto.getNumber());
        player.setPosition(dto.getPosition());
        player.setTeam(dto.getTeam());
        player.setImg(img);
        return player;
    }

    @Named("modelToDto")
    public static PlayersDto toDto(Players player) {
        PlayersDto dto = new PlayersDto();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setNumber(player.getNumber());
        dto.setAge(player.getAge());
        dto.setImg(SerializationUtils.deserialize(player.getImg()));
        return dto;
    }
}
