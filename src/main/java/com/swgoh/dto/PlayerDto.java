package com.swgoh.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swgoh.entity.Player;
import lombok.Data;

import java.util.List;

@Data
public class PlayerDto {

    private String id;
    private Long allyCode;
    private String name;
    private Long level;
    private String guildRefId;
    private String guildName;
    private String guildBannerColor;
    private String guildBannerLogo;
    private String guildTypeId;
    private Long lastActivity;
    private Long poUTCOffsetMinutes;
    private Long grandArenaLifeTime;
    private Long updated;
    @JsonIgnore
    private List<ToonDto> roster;

    @JsonIgnore
    private String titles;
    @JsonIgnore
    private String stats;
    @JsonIgnore
    private String arena;
    @JsonIgnore
    private String portraits;
    @JsonIgnore
    private String grandArena;

    public Player toPlayer() {
        Player player = new Player();

        player.setSwgohId(id);
        player.setPlayerName(name);
        player.setLevel(level);
        player.setAllyCode(allyCode);

        return player;
    }

}
