package com.example.footballers.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Players {

    public Players() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;
    private String Name;
    private Integer Number;
    private Integer Age;
    private byte[] Img;
    private Integer Team;
    private Integer Position;
    @OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "Player", referencedColumnName = "Id")
    private List<Skills> Skills;

    public List<com.example.footballers.models.Skills> getSkills() {
        return Skills;
    }

    /*public Skills getSkillsByYear(Integer year) {
        List<Skills> skills = getSkills();
        Skills result = null;
        for (Skills skill: skills) {
            if (Objects.equals(skill.getSeasonStart(), year)) {
                result = skill;
            }
        }
        return result;
    }*/

    public void setSkills(List<com.example.footballers.models.Skills> skills) {
        Skills = skills;
    }

    public Integer getPosition() {
        return Position;
    }

    public void setPosition(Integer position) {
        Position = position;
    }

    public Integer getTeam() {
        return Team;
    }

    public void setTeam(Integer team) {
        Team = team;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public byte[] getImg() {
        return Img;
    }

    public void setImg(byte[] img) {
        Img = img;
    }
}
