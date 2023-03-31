package com.example.footballers.repos.interfaces;

import com.example.footballers.models.Players;
import com.example.footballers.models.Skills;

public interface CustomSkillsRepos {
    Skills getSkillsByPlayerAndSeason(Integer id, Integer season);
}
