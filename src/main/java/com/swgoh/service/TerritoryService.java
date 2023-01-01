package com.swgoh.service;

import com.swgoh.entity.Territory;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TerritoryService {
    Territory getTerritory(Long id);

    List<Territory> getTerritories(Long battleId);

    Territory saveTerritory(Territory territory);

    List<Territory> saveTerritories(List<Territory> territories);
}
