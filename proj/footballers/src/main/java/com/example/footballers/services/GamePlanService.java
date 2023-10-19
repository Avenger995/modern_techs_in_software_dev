package com.example.footballers.services;

import com.example.footballers.dto.FormationsDto;
import com.example.footballers.dto.GamePlansDto;
import com.example.footballers.mappers.FormationsMapper;
import com.example.footballers.mappers.GamePlansMapper;
import com.example.footballers.models.GamePlans;
import com.example.footballers.models.Players;
import com.example.footballers.repos.interfaces.IFormationsRepos;
import com.example.footballers.repos.interfaces.IGamePlansRepos;
import com.example.footballers.services.interfaces.IGamePlanService;
import org.springframework.stereotype.Service;

@Service
public class GamePlanService implements IGamePlanService {

    private final IGamePlansRepos _gamePlanRepos;
    private final IFormationsRepos _formationsRepos;

    public GamePlanService(IGamePlansRepos gamePlanRepos, IFormationsRepos formationsRepos) {
        _formationsRepos = formationsRepos;
        _gamePlanRepos = gamePlanRepos;
    }

    @Override
    public Integer addNewGamePlan(GamePlansDto dto) {
        GamePlans gamePlan = GamePlansMapper.toModel(dto);
        _gamePlanRepos.save(gamePlan);
        return gamePlan.getId();
    }

    @Override
    public Iterable<GamePlansDto> getAllGamePlansByTeam(Integer teamId) {
        Iterable<FormationsDto> formations = FormationsMapper.toDtoIterable(_formationsRepos.findAll());
        return GamePlansMapper.toDtoIterable(_gamePlanRepos.getGamePlansByTeam(teamId), formations);
    }

    @Override
    public void deleteGamePlanById(Integer id) {
        GamePlans gamePlan = _gamePlanRepos.findById(id).orElse(null);
        _gamePlanRepos.delete(gamePlan);
        return;
    }
}
