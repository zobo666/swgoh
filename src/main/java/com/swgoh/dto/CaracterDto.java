package com.swgoh.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swgoh.entity.PlayerCaracter;
import lombok.Data;

@Data
public class CaracterDto {

    private String id;
    private String defId;
    private String nameKey;
    private Long rarity;
    private Long level;
    private Long xp;
    private Long gear;
    private Long gp;
    private RelicDto relic;


    @JsonIgnore
    private String equipped;
    @JsonIgnore
    private Long combatType;
    @JsonIgnore
    private String skills;
    @JsonIgnore
    private String mods;
    @JsonIgnore
    private String crew;
    @JsonIgnore
    private String primaryUnitStat;

    @Data
    public class RelicDto {
        private Long currentTier;
    }

    public PlayerCaracter toPlayerCaracter() {
        PlayerCaracter playerCaracter = new PlayerCaracter();

        playerCaracter.setGp(gp);
        playerCaracter.setRarity(rarity);
        playerCaracter.setGear(gear);
        playerCaracter.setLevel(level);
        playerCaracter.setSwgohId(id);

        if (relic != null) {
            playerCaracter.setRelicTier(relic.currentTier);
        }

        return playerCaracter;
    }
}
