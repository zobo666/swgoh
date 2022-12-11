package com.swgoh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="players")
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonProperty("id")
    private String swgohId;

    @JsonProperty("guildMemberLevel")
    private Long guildMemberLevel;

    private Long level;

    @JsonProperty("name")
    private String playerName;

    private Long allyCode;

    @Transient
    private Long gp;

    @Transient
    private Long gpChar;

    @Transient
    private Long gpShip;

    @Transient
    private Long updated;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "guild_id")
    @JsonIgnore
    private Guild guild;

}
