package com.example.footballers.mappers;

import com.example.footballers.dto.PlayersDto;
import com.example.footballers.dto.TeamsDto;
import com.example.footballers.models.Players;
import com.example.footballers.models.Teams;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface PlayersMapper {
    PlayersMapper INSTANCE = Mappers.getMapper(PlayersMapper.class);

    @Named("modelToDto")
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
    public static Players toModel(Map<String, Object> dto) {
        Players player = new Players();
        byte[] img = SerializationUtils.serialize(dto.get("img"));
        player.setAge(Integer.parseInt((String)dto.get("age")));
        player.setName((String)dto.get("name"));
        player.setNumber(Integer.parseInt((String)dto.get("number")));
        player.setPosition((Integer)dto.get("position"));
        player.setTeam(Integer.parseInt((String)dto.get("team")));
        player.setImg(img);
        return player;
    }
}
