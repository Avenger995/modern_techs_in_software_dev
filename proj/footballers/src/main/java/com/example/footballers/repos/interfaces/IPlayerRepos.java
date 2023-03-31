package com.example.footballers.repos.interfaces;

import com.example.footballers.models.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepos extends JpaRepository<Players, Integer>, CustomPlayerRepos {

}
