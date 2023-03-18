package com.example.footballers.repos.interfaces;

import com.example.footballers.models.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamsRepos extends JpaRepository<Teams, Integer> {
}
