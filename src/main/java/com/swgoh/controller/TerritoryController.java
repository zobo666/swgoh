package com.swgoh.controller;

import com.swgoh.entity.Battle;
import com.swgoh.entity.Territory;
import com.swgoh.service.BattleService;
import com.swgoh.service.TerritoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/swgoh")
@Slf4j
public class TerritoryController {
    @Autowired
    private TerritoryService territoryService;

    @Autowired
    private BattleService battleService;

    @GetMapping(value = "/listTerritory/{battleId}")
    public String populateTerritoryList(Model model, @PathVariable(name="battleId") Long battleId) {

        List<Territory> territories = territoryService.getTerritories(battleId);
        model.addAttribute("territories", territories);
        return "territory-list";
    }

    @GetMapping(value = "/editTerritory/{territoryId}")
    public String editTerritory(Model model, @PathVariable(name="territoryId") Long territoryId) {

        Territory territory = territoryService.getTerritory(territoryId);
        model.addAttribute("territory", territory);
        model.addAttribute("battleId", territory.getBattle().getId());
        return "territory-editor";
    }

    @PostMapping(value = "/saveTerritory")
    public String saveTerritory(@ModelAttribute(value="territory") Territory territory, Model model) {


        Territory result = territoryService.saveTerritory(territory);

        return "redirect:/swgoh/listTerritory/%s".formatted(result.getId());
    }
}
