package com.swgoh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swgoh.entity.Guild;
import com.swgoh.entity.Player;
import com.swgoh.repository.GuildRepository;
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
public class GuildService {

    @Autowired
    private GuildRepository guildRepository;

    public Guild getGuild(int allyCode) {

        SwgohAPI swgohAPI = new SwgohAPIBuilder()
                .withUsername("zobo666")
                .withPassword("commodore64")
                .build();

        CompletableFuture<String> guildJson = swgohAPI.getGuild(829548593);

        Guild guild = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String guildInfo = guildJson.get();
            log.info(guildInfo);

            guild = mapper.readValue(guildInfo.substring(1, guildInfo.length() - 1), Guild.class);

            Optional<Guild> result = guildRepository.findBySwgohId(guild.getSwgohId());
            if (!result.isEmpty()) {
                Guild existingGuild = result.get();
                existingGuild.setName(guild.getName());
                existingGuild.setDescription(guild.getDescription());
                existingGuild.setBannerColor(guild.getBannerColor());
                existingGuild.setBannerLogo(guild.getBannerLogo());
                List<Player> players = guild.getPlayers();

                for(Player player : players) {
                    player.setGuild(existingGuild);
                }

                existingGuild.setPlayers(players);

                return guildRepository.save(existingGuild);
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return guildRepository.save(guild);
    }
}
