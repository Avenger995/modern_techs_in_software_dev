package com.example.footballers.mappers;

import com.example.footballers.dto.PositionListDto;
import com.example.footballers.models.PositionList;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

@Mapper
public interface PositionListMapper {
    PositionListMapper INSTANCE = Mappers.getMapper(PositionListMapper.class);

    @Named("modelToDto")
    public static Iterable<PositionListDto> toDtoIterable(Iterable<PositionList> positionLists){
        ArrayList<PositionListDto> dtos = new ArrayList<PositionListDto>();
        for (PositionList positionList: positionLists) {
            PositionListDto dto = new PositionListDto();
            dto.setId(positionList.getId());
            dto.setPosition(positionList.getPosition());
            dto.setPlayers(PlayersMapper.toDtoIterable(positionList.getPlayers()));
            dtos.add(dto);
        }
        return dtos;
    }
}
