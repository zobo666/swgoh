package com.swgoh.service;

import com.swgoh.entity.Battle;

import java.util.List;

public interface BattleService {

    Battle getBattle(Long id);

    List<Battle> getBattles();

    Battle saveBattle(Battle battle);
}
