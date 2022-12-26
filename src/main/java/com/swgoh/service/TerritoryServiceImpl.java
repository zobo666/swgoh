package com.swgoh.service;

import com.swgoh.entity.Territory;
import com.swgoh.repository.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerritoryServiceImpl implements TerritoryService {

    @Autowired
    private TerritoryRepository territoryRepository;

    @Override
    public Territory getTerritory(Long id) {

        Territory territory = null;

        Optional<Territory> result = territoryRepository.findById(id);

        if (result.isPresent()) {
            territory = result.get();
        }
        return territory;
    }

    @Override
    public List<Territory> getTerritories(Long battleId) {
        return territoryRepository.findByBattleId(battleId);
    }

    @Override
    public Territory saveTerritory(Territory territory) {
        return saveTerritory(territory);
    }
}
