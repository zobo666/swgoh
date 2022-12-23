package com.swgoh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swgoh.dto.PlayerDto;
import com.swgoh.entity.Guild;
import com.swgoh.entity.Player;
import com.swgoh.property.SwgohProperties;
import com.swgoh.repository.GuildRepository;
import com.swgoh.repository.PlayerRepository;
import help.swgoh.api.SwgohAPI;
import help.swgoh.api.SwgohAPIBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class PlayerService {

    @Autowired
    private SwgohProperties swgohProperties;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GuildRepository guildRepository;

    public Player getPlayer(int allyCode) {

        SwgohAPI swgohAPI = new SwgohAPIBuilder()
                .withUsername(swgohProperties.getUsername())
                .withPassword(swgohProperties.getPassword())
                .build();

        CompletableFuture<String> playerJson = swgohAPI.getPlayer(allyCode);

        Player player;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String playerInfo = playerJson.get();
            log.info(playerInfo);

            String playerinfo = playerInfo.substring(1, playerInfo.length() - 1);

            PlayerDto playerDto = mapper.readValue(playerinfo, PlayerDto.class);

            Optional<Player> result = playerRepository.findBySwgohId(playerDto.getId());
            Optional<Guild> guild = guildRepository.findBySwgohId(playerDto.getGuildRefId());

            if (result.isPresent()) {
                player = result.get();
                player.setPlayerName(playerDto.getName());
                player.setLevel(playerDto.getLevel());
                player.setGuild(guild.get());
            } else {
                player = playerDto.toPlayer();
                player.setGuild(guild.get());
            }

        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return playerRepository.save(player);
    }

    public List<Player> savePlayers(List<Player> players) {
        return playerRepository.saveAll(players);
    }

    public Player getPlayer(String swgohId) {

        Optional<Player> result = playerRepository.findBySwgohId(swgohId);

        Player player = null;

        if (result.isPresent()) {
            player = result.get();
        }

        return player;
    }
}
