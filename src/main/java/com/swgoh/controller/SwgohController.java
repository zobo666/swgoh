package com.swgoh.controller;

import com.swgoh.entity.Guild;
import com.swgoh.service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swgoh")
public class SwgohController {

    @Autowired
    GuildService guildService;

    @GetMapping("/guild")
    public ResponseEntity<Guild> findUserById(@Param(value = "allyCode") int allyCode) {

        Guild guild = guildService.getGuild(allyCode);

        return ResponseEntity.ok().body(guild);
    }
}
