package com.example.footballers.repos.interfaces;

import com.example.footballers.models.Players;

public interface CustomPlayerRepos {
    Iterable<Players> getPlayersByTeam(Integer id);
}
