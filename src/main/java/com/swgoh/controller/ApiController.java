package com.swgoh.controller;

import com.swgoh.entity.Guild;
import com.swgoh.entity.Player;
import com.swgoh.service.GuildServiceImpl;
import com.swgoh.service.PlayerServiceImpl;
import com.swgoh.service.CaracterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swgoh/api")
public class ApiController {

    @Autowired
    GuildServiceImpl guildService;

    @Autowired
    PlayerServiceImpl playerService;

    @Autowired
    CaracterServiceImpl caracterService;

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
