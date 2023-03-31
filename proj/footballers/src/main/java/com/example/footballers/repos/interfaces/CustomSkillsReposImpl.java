package com.example.footballers.repos.interfaces;

import com.example.footballers.models.Skills;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomSkillsReposImpl implements  CustomSkillsRepos {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Skills getSkillsByPlayerAndSeason(Integer id, Integer season) {
        Skills result;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Skills> query = cb.createQuery(Skills.class);
        Root<Skills> root = query.from(Skills.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(root.get("Player"), id));
        predicates.add(cb.equal(root.get("SeasonStart"), season));
        query.where(predicates.toArray(new Predicate[0]));
        try {
            result = entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            result = null;
        }
        return result;
    }
}
