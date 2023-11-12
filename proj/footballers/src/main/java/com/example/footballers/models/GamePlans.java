package com.example.footballers.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GamePlans {

    public GamePlans() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;

    private Integer Formation;

    private String Name;

    private Integer Team;

    @Column(columnDefinition = "JSON")
    private String Array;

    private Date DtCreation;

    private String Owner;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getFormation() {
        return Formation;
    }

    public void setFormation(Integer formationId) {
        Formation = formationId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArray() {
        return Array;
    }

    public void setArray(String array) {
        Array = array;
    }

    public Integer getTeam() {
        return Team;
    }

    public void setTeam(Integer team) {
        Team = team;
    }

    public Date getDtCreation() {
        return DtCreation;
    }

    public void setDtCreation(Date dtCreation) {
        DtCreation = dtCreation;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }
}
