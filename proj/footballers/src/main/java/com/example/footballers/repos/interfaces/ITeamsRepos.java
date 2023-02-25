package com.example.footballers.repos.interfaces;

import com.example.footballers.models.Teams;
import org.springframework.data.repository.CrudRepository;

public interface ITeamsRepos extends CrudRepository<Teams, Integer> {
}
