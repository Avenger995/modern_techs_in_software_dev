package com.example.footballers.dto;

public class PlayersDto {
    private Integer Id;
    private String Name;
    private Integer Number;
    private Integer Age;
    private Integer Position;
    private Integer Team;
    private Object Img;


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

    public Object getImg() {
        return Img;
    }

    public void setImg(Object img) {
        Img = img;
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
}
