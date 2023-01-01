package com.swgoh.controller;

import com.swgoh.dto.OperationListDto;
import com.swgoh.entity.Operation;
import com.swgoh.entity.Territory;
import com.swgoh.repository.OperationRepository;
import com.swgoh.service.OperationService;
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
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private TerritoryService territoryService;

    @GetMapping(value = "/operations/{territoryId}")
    public String populateOperationList(Model model, @PathVariable(name="territoryId") Long territoryId) {

        List<Operation> operations = operationService.getOperations(territoryId);
        Territory territory = territoryService.getTerritory(territoryId);

        OperationListDto operationList = new OperationListDto();
        operationList.setOperations(operations);

        model.addAttribute("operations", operationList);
        model.addAttribute("territory", territory);

        return "operation-editor";
    }

    @PostMapping(value="/operations/save")
    private String saveOperations(@ModelAttribute OperationListDto operationList) {

        operationService.saveOperations(operationList.getOperations());

        Territory territory = operationList.getOperations().get(0).getTerritory();

        return "redirect:/swgoh/territories/%s".formatted(territory.getBattle().getId());
    }
}
