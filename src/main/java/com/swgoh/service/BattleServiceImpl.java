package com.swgoh.service;

import com.swgoh.entity.Battle;
import com.swgoh.repository.BattleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BattleServiceImpl implements BattleService {

    @Autowired
    BattleRepository battleRepository;

    @Override
    public Battle getBattle(Long id) {

        Battle battle = null;

        Optional<Battle> result = battleRepository.findById(id);

        if (result.isPresent()) {
            battle = result.get();
        }
        return battle;
    }

    @Override
    public List<Battle> getBattles() {
        return battleRepository.findAll();
    }
    @Override
    public Battle saveBattle(Battle battle) {

        return battleRepository.save(battle);
    }
}
