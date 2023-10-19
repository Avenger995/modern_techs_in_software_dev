package com.example.footballers.dto;

public class FormationsDto {

    public FormationsDto() {
    }

    private Integer Id;
    private String Formation;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFormation() {
        return Formation;
    }

    public void setFormation(String formation) {
        Formation = formation;
    }
}
