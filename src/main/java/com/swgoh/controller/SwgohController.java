package com.swgoh.controller;

import com.swgoh.entity.Guild;
import com.swgoh.entity.Player;
import com.swgoh.service.GuildService;
import com.swgoh.service.PlayerService;
import com.swgoh.service.CaracterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swgoh")
public class SwgohController {

    @Autowired
    GuildService guildService;

    @Autowired
    PlayerService playerService;

    @Autowired
    CaracterService caracterService;

    @GetMapping("/guild/{allyCode}")
    public ResponseEntity<Guild> updateGuild(@PathVariable(value = "allyCode") int allyCode) {

        Guild guild = guildService.getGuild(allyCode);

        return ResponseEntity.ok().body(guild);
    }

    @GetMapping("/player/{allyCode}")
    public ResponseEntity<Player> updatePlayer(@PathVariable(value = "allyCode") int allyCode) {

        Guild guild = guildService.getGuild(allyCode);
        Player player = playerService.getPlayer(guild, allyCode);

        return ResponseEntity.ok().body(player);
    }

    @GetMapping("/toon/{allyCode}")
    public ResponseEntity<String> updateToons(@PathVariable(value = "allyCode") int allyCode) {

        caracterService.generateCaracterList(allyCode);

        return ResponseEntity.ok().body("Toon data refreshed!!");
    }
}
