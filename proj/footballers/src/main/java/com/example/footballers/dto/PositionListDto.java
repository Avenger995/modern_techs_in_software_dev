package com.example.footballers.dto;

import java.util.List;

public class PositionListDto {
    public PositionListDto() {}


    private Integer Id;
    private String Position;
    private List<PlayersDto> Players;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public List<com.example.footballers.dto.PlayersDto> getPlayers() {
        return Players;
    }

    public void setPlayers(List<com.example.footballers.dto.PlayersDto> players) {
        Players = players;
    }
}
