package com.example.footballers.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class PositionList {

    public PositionList() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String Position;

    @OneToMany(targetEntity = Players.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "position", referencedColumnName = "Id")
    private List<Players> Players;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public List<com.example.footballers.models.Players> getPlayers() {
        return Players;
    }

    public void setPlayers(List<com.example.footballers.models.Players> players) {
        Players = players;
    }
}
