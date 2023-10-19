package com.example.footballers.repos.interfaces;

import com.example.footballers.models.GamePlans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGamePlansRepos extends JpaRepository<GamePlans, Integer>, CustomGamePlansRepos {
}
