package com.example.footballers.repos.interfaces;

import com.example.footballers.models.Formations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFormationsRepos extends JpaRepository<Formations, Integer> {
}
