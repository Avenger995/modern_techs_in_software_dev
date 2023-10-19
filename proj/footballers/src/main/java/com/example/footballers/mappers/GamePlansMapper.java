package com.example.footballers.mappers;

import com.example.footballers.dto.FormationsDto;
import com.example.footballers.dto.GamePlansDto;
import com.example.footballers.models.Formations;
import com.example.footballers.models.GamePlans;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper
public interface GamePlansMapper {

    GamePlansMapper INSTANSE = Mappers.getMapper(GamePlansMapper.class);

    @Named("dtoToModel")
    public static GamePlans toModel(GamePlansDto gamePlansDto) {
        GamePlans gamePlans = new GamePlans();
        gamePlans.setFormation(gamePlansDto.getFormation());
        gamePlans.setName(gamePlansDto.getName());
        gamePlans.setTeam(gamePlansDto.getTeam());
        gamePlans.setArray(gamePlansDto.getArray());
        return gamePlans;
    }

    @Named("modelToDtoIterable")
    public static List<GamePlansDto> toDtoIterable(Iterable<GamePlans> gamePlans,
                                                   Iterable<FormationsDto> formations) {
        ArrayList<GamePlansDto> dtos = new ArrayList<>();
        for (GamePlans gamePlan: gamePlans) {
            GamePlansDto dto = new GamePlansDto();
            dto.setId(gamePlan.getId());
            dto.setName(gamePlan.getName());
            dto.setFormation(gamePlan.getFormation());
            dto.setFormationName(getFormationNameById(gamePlan.getFormation(), formations));
            dto.setTeam(gamePlan.getTeam());
            dto.setArray(gamePlan.getArray());
            dtos.add(dto);
        }
        return dtos;
    }

    private static String getFormationNameById(Integer id, Iterable<FormationsDto> formations) {
        for (FormationsDto formation: formations) {
            if (Objects.equals(formation.getId(), id)) return formation.getFormation();
        }
        return null;
    }
}
