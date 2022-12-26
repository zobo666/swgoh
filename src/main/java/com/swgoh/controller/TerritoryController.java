package com.swgoh.controller;

import com.swgoh.entity.Battle;
import com.swgoh.entity.Territory;
import com.swgoh.service.BattleService;
import com.swgoh.service.TerritoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/swgoh")
@Slf4j
public class TerritoryController {
    @Autowired
    private TerritoryService territoryService;

    @GetMapping(value = "/editTerritory/{battleId}")
    public String populateTerritoryList(Model model, @PathVariable(name="battleId") Long battleId) {

        List<Territory> territories = territoryService.getTerritories(battleId);
        model.addAttribute("territories", territories);
        return "territory-editor";
    }
}
