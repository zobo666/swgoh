package com.swgoh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swgoh.dto.CaracterDto;
import com.swgoh.dto.PlayerDto;
import com.swgoh.entity.Caracter;
import com.swgoh.entity.Guild;
import com.swgoh.entity.Player;
import com.swgoh.entity.PlayerCaracter;
import com.swgoh.property.SwgohProperties;
import com.swgoh.repository.GuildRepository;
import com.swgoh.repository.PlayerCaracterRepository;
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
public class PlayerServiceImpl {
    @Autowired
    private PlayerCaracterRepository playerCaracterRepository;

    @Autowired
    private SwgohProperties swgohProperties;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GuildRepository guildRepository;

    @Autowired
    private CaracterServiceImpl caracterService;

    public Player getPlayer(Guild guild, int allyCode) {

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

            playerInfo = playerInfo.substring(1, playerInfo.length() - 1);

            PlayerDto playerDto = mapper.readValue(playerInfo, PlayerDto.class);

            Optional<Player> result = playerRepository.findBySwgohId(playerDto.getId());

            if (result.isPresent()) {
                player = result.get();
                player.setPlayerName(playerDto.getName());
                player.setLevel(playerDto.getLevel());
                player.setGuild(guild);
            } else {
                player = playerDto.toPlayer();
                player.setGuild(guild);
            }

            addPlayerCaracters(player, playerDto.getRoster());

        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return playerRepository.save(player);
    }

    public Player getPlayer(String swgohId) {

        Optional<Player> result = playerRepository.findBySwgohId(swgohId);

        Player player = null;

        if (result.isPresent()) {
            player = result.get();
        }

        return player;
    }

    private void addPlayerCaracters(Player player, List<CaracterDto> caracterDtos) {

        caracterDtos.stream().forEach(c -> {


            Caracter caracter = caracterService.getCaracter(c.getDefId());
            Optional<PlayerCaracter> result =playerCaracterRepository.findByPlayerIdAndCaracterId(player.getId(), caracter.getId());

            PlayerCaracter playerCaracter;
            if (result.isPresent()) {
                playerCaracter = result.get();

                playerCaracter.setGp(c.getGp());
                playerCaracter.setGear(c.getGear());
                playerCaracter.setRarity(c.getRarity());
                playerCaracter.setLevel(c.getLevel());

                if (c.getRelic() != null) {
                  playerCaracter.setRelicTier(c.getRelic().getCurrentTier());
                }
            } else {
                playerCaracter = c.toPlayerCaracter();
            }

            player.getPlayerCaracters().add(playerCaracter);
        });
    }
}
