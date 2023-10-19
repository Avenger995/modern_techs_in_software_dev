package com.example.footballers.repos.interfaces;

import com.example.footballers.models.GamePlans;

public interface CustomGamePlansRepos {

    Iterable<GamePlans> getGamePlansByTeam(Integer teamId);
}
