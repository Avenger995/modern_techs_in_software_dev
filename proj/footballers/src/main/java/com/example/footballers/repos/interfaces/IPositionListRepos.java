package com.example.footballers.repos.interfaces;

import com.example.footballers.models.PositionList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionListRepos extends JpaRepository<PositionList, Integer> {
}
