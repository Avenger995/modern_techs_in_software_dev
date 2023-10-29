package com.example.footballers.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<com.example.footballers.models.Players> getPlayersByTeam(Integer teamId) {
        ArrayList<com.example.footballers.models.Players> result = new ArrayList<>();
        for (Players player: Players) {
            if (Objects.equals(player.getTeam(), teamId)) {
                result.add(player);
            }
        }
        return result;
    }

    public void setPlayers(List<com.example.footballers.models.Players> players) {
        Players = players;
    }
}
