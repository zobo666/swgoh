package com.swgoh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swgoh.dto.GuildDto;
import com.swgoh.dto.GuildPlayerDto;
import com.swgoh.dto.PlayerDto;
import com.swgoh.entity.Guild;
import com.swgoh.entity.Player;
import com.swgoh.property.SwgohProperties;
import com.swgoh.repository.GuildRepository;
import help.swgoh.api.SwgohAPI;
import help.swgoh.api.SwgohAPIBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class GuildService {

    @Autowired
    private SwgohProperties swgohProperties;
    @Autowired
    private GuildRepository guildRepository;

    @Autowired
    private PlayerService playerService;

    public Guild getGuild(int allyCode) {

        SwgohAPI swgohAPI = new SwgohAPIBuilder()
                .withUsername(swgohProperties.getUsername())
                .withPassword(swgohProperties.getPassword())
                .build();

        CompletableFuture<String> guildJson = swgohAPI.getGuild(allyCode);

        Guild guild = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String guildInfo = guildJson.get();
            log.info(guildInfo);

            GuildDto guildDto = mapper.readValue(guildInfo.substring(1, guildInfo.length() - 1), GuildDto.class);

            Optional<Guild> result = guildRepository.findBySwgohId(guildDto.getId());
            if (!result.isEmpty()) {
                guild = result.get();
                guild.setGuildName(guildDto.getName());
                guild.setDescription(guildDto.getDesc());
                guild.setDescription(guildDto.getMessage());
            } else {
                guild = guildDto.toGuild();
            }

            addPlayers(guild, guildDto.getRoster());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return guildRepository.save(guild);
    }

    private void addPlayers(Guild guild, List<GuildPlayerDto> playerDtos) {

        playerDtos.stream().forEach(p -> {

            Player player = playerService.getPlayer(guild, p.getAllyCode().intValue());

            if (player == null) {
                player = p.toPlayer();
            }

            player.setGuild(guild);
            guild.getPlayers().add(player);
        });
    }
}
