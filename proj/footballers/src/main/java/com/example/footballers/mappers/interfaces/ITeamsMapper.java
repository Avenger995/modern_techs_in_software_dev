package com.example.footballers.mappers.interfaces;

import com.example.footballers.dto.TeamsDto;
import com.example.footballers.models.Teams;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ITeamsMapper {
    ITeamsMapper INSTANCE = Mappers.getMapper(ITeamsMapper.class);

    TeamsDto toDto(Teams teams);

    Iterable<TeamsDto> toDtoIterable(Iterable<Teams> teams);
}
