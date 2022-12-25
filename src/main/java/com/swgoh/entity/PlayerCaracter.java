package com.swgoh.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="player_caracters")
@Data
public class PlayerCaracter {

    @Id
    private Long id;

    private String swgohId;
    private Long rarity;
    private Long level;
    private Long gear;
    private Long gp;
    private Long relicTier;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "caracter_id")
    private Caracter caracter;
}
