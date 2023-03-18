package com.example.footballers.repos.interfaces.custom;

import com.example.footballers.models.Players;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomPlayerReposImpl implements CustomPlayerRepos {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Iterable<Players> getPlayersByTeam(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Players> query = cb.createQuery(Players.class);
        Root<Players> root = query.from(Players.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get("Team"), id));
        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
