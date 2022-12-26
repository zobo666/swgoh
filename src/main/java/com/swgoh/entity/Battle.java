package com.swgoh.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="battles")
@Data
public class Battle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    @JsonIgnore
    @OneToMany(mappedBy = "battle", cascade = CascadeType.ALL)
    private List<Territory> territories = new ArrayList<>();
}
