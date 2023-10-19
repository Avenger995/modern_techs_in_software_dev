package com.example.footballers.dto;

public class GamePlansDto {

    public GamePlansDto() {
    }

    private Integer Id;

    private Integer Formation;

    private String FormationName;

    private String Name;

    private Integer Team;

    private String Array;

    public String getFormationName() {
        return FormationName;
    }

    public void setFormationName(String formationName) {
        FormationName = formationName;
    }

    public String getArray() {
        return Array;
    }

    public void setArray(String array) {
        Array = array;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getFormation() {
        return Formation;
    }

    public void setFormation(Integer formation) {
        Formation = formation;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getTeam() {
        return Team;
    }

    public void setTeam(Integer team) {
        Team = team;
    }
}
