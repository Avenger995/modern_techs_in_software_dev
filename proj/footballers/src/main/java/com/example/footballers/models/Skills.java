package com.example.footballers.models;

import javax.persistence.*;

@Entity
public class Skills {

    public Skills() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer Id;
    private Integer SeasonStart;
    private Integer Player;
    private Integer Speed;
    private Integer Shot;
    private Integer Dribbling;
    private Integer Passing;
    private Integer Defence;
    private Integer Physic;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getSpeed() {
        return Speed;
    }

    public void setSpeed(Integer speed) {
        Speed = speed;
    }

    public Integer getShot() {
        return Shot;
    }

    public void setShot(Integer shot) {
        Shot = shot;
    }

    public Integer getDribbling() {
        return Dribbling;
    }

    public void setDribbling(Integer dribbling) {
        Dribbling = dribbling;
    }

    public Integer getPassing() {
        return Passing;
    }

    public void setPassing(Integer passing) {
        Passing = passing;
    }

    public Integer getDefence() {
        return Defence;
    }

    public void setDefence(Integer defence) {
        Defence = defence;
    }

    public Integer getPhysic() {
        return Physic;
    }

    public void setPhysic(Integer physic) {
        Physic = physic;
    }

    public Integer getPlayer() {
        return Player;
    }

    public void setPlayer(Integer player) {
        Player = player;
    }

    public Integer getSeasonStart() {
        return SeasonStart;
    }

    public void setSeasonStart(Integer seasonStart) {
        SeasonStart = seasonStart;
    }
}
