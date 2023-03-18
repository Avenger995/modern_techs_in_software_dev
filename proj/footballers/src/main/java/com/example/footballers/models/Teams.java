package com.example.footballers.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Teams {
    public Teams() {
    }

    public Teams(String name, Date dateTimeAdd, String shortName) {
        Name = name;
        DateTimeAdd = dateTimeAdd;
        ShortName = shortName;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    private String Name;
    private Date DateTimeAdd;
    private String ShortName;
    @Nullable
    private byte[] Img;

    @OneToMany(targetEntity = Players.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "team", referencedColumnName = "Id")
    private List<Players> Players;

    public List<com.example.footballers.models.Players> getPlayers() {
        return Players;
    }

    public void setPlayers(List<com.example.footballers.models.Players> players) {
        Players = players;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
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

    public Date getDateTimeAdd() {
        return DateTimeAdd;
    }

    public void setDateTimeAdd(Date dateTimeAdd) {
        DateTimeAdd = dateTimeAdd;
    }

    public byte[] getImg() {
        return Img;
    }

    public void setImg(byte[] img) {
        Img = img;
    }
}
