package com.example.footballers.services.interfaces;

import com.example.footballers.dto.GamePlansDto;

public interface IGamePlanService {

    Integer addNewGamePlan(GamePlansDto dto);

    Iterable<GamePlansDto> getAllGamePlansByTeam(Integer teamId);

    void deleteGamePlanById(Integer id);
}
