package com.swgoh.controller;

import com.swgoh.entity.Guild;
import com.swgoh.entity.Player;
import com.swgoh.service.GuildService;
import com.swgoh.service.PlayerService;
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

    @GetMapping("/guild/{allyCode}")
    public ResponseEntity<Guild> findGuildById(@PathVariable(value = "allyCode") int allyCode) {

        Guild guild = guildService.getGuild(allyCode);

        return ResponseEntity.ok().body(guild);
    }

    @GetMapping("/player/{allyCode}")
    public ResponseEntity<Player> findUserById(@PathVariable(value = "allyCode") int allyCode) {

        Player player = playerService.getPlayer(allyCode);

        return ResponseEntity.ok().body(player);
    }
}
