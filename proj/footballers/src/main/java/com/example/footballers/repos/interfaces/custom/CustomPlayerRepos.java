package com.example.footballers.repos.interfaces.custom;

import com.example.footballers.models.Players;

public interface CustomPlayerRepos {
    Iterable<Players> getPlayersByTeam(Integer id);
}
