package com.swgoh.controller;

import com.swgoh.dto.TerritorylistDto;
import com.swgoh.entity.Territory;
import com.swgoh.service.BattleService;
import com.swgoh.service.TerritoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/swgoh")
@Slf4j
public class TerritoryController {
    @Autowired
    private TerritoryService territoryService;

    @Autowired
    private BattleService battleService;

    @GetMapping(value = "/territories/{battleId}")
    public String populateTerritoryList(Model model, @PathVariable(name="battleId") Long battleId) {

        List<Territory> territories = territoryService.getTerritories(battleId);

        TerritorylistDto territorylist = new TerritorylistDto();
        territorylist.setTerritories(territories);

        model.addAttribute("territories", territorylist);

        return "territory-editor";
    }

    @PostMapping(value = "/territories/save")
    public String saveTerritory(@ModelAttribute(value="territories") TerritorylistDto territories) {

        territoryService.saveTerritories(territories.getTerritories());

        Territory territory = territories.getTerritories().get(0);

        return "redirect:/swgoh/territories/%s".formatted(territory.getBattle().getId());
    }
}
