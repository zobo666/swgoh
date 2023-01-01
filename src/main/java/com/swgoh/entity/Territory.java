package com.swgoh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="territories")
@Data
public class Territory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long zoneNo;

    private String name;

    private String alignment;

    private Long firstStar;

    private Long secondStar;

    private Long thirdStar;

    private Long relic;

    @JsonIgnore
    @NotNull
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "battle_id")
    private Battle battle;

    @OneToMany(mappedBy = "territory", cascade = CascadeType.ALL)
    private List<Operation> players = new ArrayList<>();
}
