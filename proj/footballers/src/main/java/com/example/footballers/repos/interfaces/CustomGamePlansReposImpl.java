package com.example.footballers.repos.interfaces;

import com.example.footballers.dto.GamePlansDto;
import com.example.footballers.models.GamePlans;
import com.example.footballers.models.Players;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomGamePlansReposImpl implements CustomGamePlansRepos {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Iterable<GamePlans> getGamePlansByTeam(Integer teamId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GamePlans> query = cb.createQuery(GamePlans.class);
        Root<GamePlans> root = query.from(GamePlans.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get("Team"), teamId));
        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
