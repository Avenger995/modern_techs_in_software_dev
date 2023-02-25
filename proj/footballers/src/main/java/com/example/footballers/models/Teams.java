package com.example.footballers.models;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;

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
    private Blob Img;


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

    public Blob getImg() {
        return Img;
    }

    public void setImg(Blob img) {
        Img = img;
    }
}
