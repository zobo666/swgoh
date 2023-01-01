package com.swgoh.dto;

import com.swgoh.entity.Operation;
import com.swgoh.entity.Territory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TerritorylistDto {

    private List<Territory> territories;

    private void addTerritory(Territory territory) {

        if (territories == null) {
            territories = new ArrayList<>();
        }

        territories.add(territory);
    }
}
