package com.example.footballers.dto;

import org.springframework.lang.Nullable;

public class SkillsDto {

    public SkillsDto() {
    }

    private Integer Player;
    private Integer SeasonStart;
    @Nullable
    private Integer Speed;
    @Nullable
    private Integer Shot;
    @Nullable
    private Integer Dribbling;
    @Nullable
    private Integer Passing;
    @Nullable
    private Integer Defence;
    @Nullable
    private Integer Physic;

    public Integer getPlayer() {
        return Player;
    }

    public void setPlayer(Integer player) {
        Player = player;
    }

    public Integer getSpeed() {
        return Speed;
    }

    public void setSpeed(Integer speed) {
        Speed = speed;
    }

    public Integer getShot() {
        return Shot;
    }

    public void setShot(Integer shot) {
        Shot = shot;
    }

    public Integer getDribbling() {
        return Dribbling;
    }

    public void setDribbling(Integer dribbling) {
        Dribbling = dribbling;
    }

    public Integer getPassing() {
        return Passing;
    }

    public void setPassing(Integer passing) {
        Passing = passing;
    }

    public Integer getDefence() {
        return Defence;
    }

    public void setDefence(Integer defence) {
        Defence = defence;
    }

    public Integer getPhysic() {
        return Physic;
    }

    public void setPhysic(Integer physic) {
        Physic = physic;
    }

    public Integer getSeasonStart() {
        return SeasonStart;
    }

    public void setSeasonStart(Integer seasonStart) {
        SeasonStart = seasonStart;
    }
}
