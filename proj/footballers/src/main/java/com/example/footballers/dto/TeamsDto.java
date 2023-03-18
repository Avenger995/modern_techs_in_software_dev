package com.example.footballers.dto;

import org.springframework.lang.Nullable;

import java.util.Date;

public class TeamsDto {
    private Integer Id;
    private String Name;
    private Date DateTimeAdd;
    private String ShortName;
    @Nullable
    private Object Img;

    public TeamsDto(Integer id, String name, Date dateTimeAdd, String shortName, @Nullable Object img) {
        Id = id;
        Name = name;
        DateTimeAdd = dateTimeAdd;
        ShortName = shortName;
        Img = img;
    }

    public TeamsDto() {
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

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    @Nullable
    public Object getImg() {
        return Img;
    }

    public void setImg(@Nullable Object img) {
        Img = img;
    }
}
