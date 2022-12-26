package com.swgoh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swgoh.dto.PlayerDto;
import com.swgoh.entity.Caracter;
import com.swgoh.property.SwgohProperties;
import com.swgoh.repository.CaracterRepository;
import help.swgoh.api.SwgohAPI;
import help.swgoh.api.SwgohAPIBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class CaracterServiceImpl implements CaracterService{

    @Autowired
    private SwgohProperties swgohProperties;

    @Autowired
    private CaracterRepository caracterRepository;

    @Override
    public void generateCaracterList(int allyCode) {

        SwgohAPI swgohAPI = new SwgohAPIBuilder()
                .withUsername(swgohProperties.getUsername())
                .withPassword(swgohProperties.getPassword())
                .build();

        CompletableFuture<String> playerJson = swgohAPI.getPlayer(allyCode);

        try {
            ObjectMapper mapper = new ObjectMapper();
            String playerInfo = playerJson.get();
            log.info(playerInfo);

            playerInfo = playerInfo.substring(1, playerInfo.length() - 1);

            PlayerDto playerDto = mapper.readValue(playerInfo, PlayerDto.class);

            playerDto.getRoster().stream().forEach(t -> {

                Optional<Caracter> result = caracterRepository.findByDefId(t.getDefId());

                if (result.isEmpty()) {
                    Caracter caracter = new Caracter();

                    caracter.setDefId(t.getId());
                    caracter.setDefId(t.getDefId());

                    caracterRepository.save(caracter);
                }
            });

        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Caracter getCaracter(String defId) {

        Caracter caracter = null;

        Optional<Caracter> result = caracterRepository.findByDefId(defId);

        if (result.isPresent()) {
            caracter = result.get();
        }

        return caracter;

   }
}
