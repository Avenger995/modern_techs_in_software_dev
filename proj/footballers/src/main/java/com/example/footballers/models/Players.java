package com.example.footballers.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
