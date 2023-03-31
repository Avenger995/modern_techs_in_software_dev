package com.example.footballers.repos.interfaces;

import com.example.footballers.models.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISkillsRepos extends JpaRepository<Skills, Integer>, CustomSkillsRepos {
}
