package com.swgoh.dto;

import com.swgoh.entity.Player;
import lombok.Data;

@Data
public class GuildPlayerDto {

    private String id;
    private Long guildMemberLevel;
    private Long level;
    private String name;
    private Long allyCode;
    private Long gp;
    private Long gpChar;
    private Long gpShip;
    private Long updated;

    public Player toPlayer() {
        Player player = new Player();

        player.setSwgohId(id);
        player.setPlayerName(name);
        player.setLevel(level);
        player.setAllyCode(allyCode);

        return player;
    }
}
