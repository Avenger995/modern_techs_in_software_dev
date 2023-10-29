package com.example.footballers.services.interfaces;

import com.example.footballers.dto.PositionListDto;
import com.example.footballers.models.PositionList;

public interface IPositionsListService {

    Iterable<PositionListDto> getAllPositionList();

    Iterable<PositionListDto> getAllPositionListByTeam(Integer teamId);
}
