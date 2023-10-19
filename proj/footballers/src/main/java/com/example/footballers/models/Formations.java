package com.example.footballers.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Formations {

    public Formations() {

    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;
    private String Formation;

    @OneToMany(targetEntity = GamePlans.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "formation", referencedColumnName = "id")
    private List<GamePlans> GamePlans;

    public List<com.example.footballers.models.GamePlans> getGamePlans() {
        return GamePlans;
    }

    public void setGamePlans(List<com.example.footballers.models.GamePlans> gamePlans) {
        GamePlans = gamePlans;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFormation() {
        return Formation;
    }

    public void setFormation(String formation) {
        Formation = formation;
    }
}
