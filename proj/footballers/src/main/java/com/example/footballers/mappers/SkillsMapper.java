package com.example.footballers.mappers;

import com.example.footballers.dto.SkillsDto;
import com.example.footballers.models.Skills;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillsMapper {
    SkillsMapper INSTANCE = Mappers.getMapper(SkillsMapper.class);

    Skills toModel(SkillsDto dto);
}
