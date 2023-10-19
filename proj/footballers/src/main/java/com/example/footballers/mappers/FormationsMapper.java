package com.example.footballers.mappers;

import com.example.footballers.dto.FormationsDto;
import com.example.footballers.models.Formations;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface FormationsMapper {

    FormationsMapper INSTANSE = Mappers.getMapper(FormationsMapper.class);

    @Named("modelToDtoIterable")
    public static List<FormationsDto> toDtoIterable(List<Formations> formationsList) {
        ArrayList<FormationsDto> dtos = new ArrayList<>();
        for (Formations formation: formationsList) {
            FormationsDto dto = new FormationsDto();
            dto.setId(formation.getId());
            dto.setFormation(formation.getFormation());
            dtos.add(dto);
        }
        return dtos;
    }
}
