package com.swgoh.service;

import com.swgoh.entity.Guild;
import com.swgoh.entity.Player;

public interface PlayerService {

    Player getPlayer(Guild guild, int allyCode);
    Player getPlayer(String swgohId);
}
