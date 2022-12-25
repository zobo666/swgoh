package com.swgoh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="guilds")
@Data
public class Guild {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String swgohId;

    private String guildName;

    @JsonProperty("desc")
    private String description;

    private String message;

    @JsonIgnore
    @OneToMany(mappedBy = "guild", cascade = CascadeType.ALL)
    private List<Player> players = new ArrayList<>();
}
