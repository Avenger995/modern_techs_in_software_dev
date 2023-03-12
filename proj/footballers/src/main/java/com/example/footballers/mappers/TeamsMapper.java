package com.example.footballers.mappers;

import com.example.footballers.dto.TeamsDto;
import com.example.footballers.models.Teams;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Mapper
public interface TeamsMapper {
    TeamsMapper INSTANCE = Mappers.getMapper(TeamsMapper.class);

    //TeamsDto toDto(Teams teams);

    //Iterable<TeamsDto> toDtoIterable(Iterable<Teams> teams);

    //Teams toModel(TeamsDto dto);

    @Named("jsonToModel")
    public static Teams toModel(Map<String, Object> dto) {
        Teams teams = new Teams();
        byte[] img = SerializationUtils.serialize(dto.get("img"));
        teams.setName((String)dto.get("name"));
        teams.setShortName((String)dto.get("shortName"));
        teams.setImg(img);
        teams.setDateTimeAdd(new Date());
        return teams;
    }

    @Named("modelToDtoIter")
    public static Iterable<TeamsDto> toDtoIterable(Iterable<Teams> teams) {
        ArrayList<TeamsDto> dtos = new ArrayList<>();
        for (Teams team: teams) {
            TeamsDto dto = new TeamsDto();
            byte[] img = team.getImg();
            Object imgObject = SerializationUtils.deserialize(img);
            dto.setId(team.getId());
            dto.setDateTimeAdd(team.getDateTimeAdd());
            dto.setName(team.getName());
            dto.setShortName(team.getShortName());
            dto.setImg(imgObject);
            dtos.add(dto);
        }
        return dtos;
    }

}
