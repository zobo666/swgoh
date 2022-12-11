package com.swgoh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="guilds")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Guild {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonProperty("id")
    @Column(name="swgoh_id")
    private String swgohId;

    @Column(name="guild_name")
    private String name;

    @JsonProperty("desc")
    private String description;

    @Transient
    private Long members;

    @Transient
    private Long status;

    @Transient
    private Long required;

    private String bannerColor;

    private String bannerLogo;

    private String message;
    @Transient
    private Long gp;

    @JsonIgnore
    @Transient
    private List<Raid> raid;

    @JsonProperty("roster")
    @OneToMany(mappedBy = "guild", cascade = CascadeType.ALL)
    private List<Player> players;
    @Transient
    private long updated;
}
