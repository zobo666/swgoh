package com.swgoh.controller;

import com.swgoh.entity.Battle;
import com.swgoh.repository.BattleRepository;
import com.swgoh.service.BattleService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/swgoh")
@Slf4j
public class BattleController {
    @Autowired
    private BattleService battleService;

    @GetMapping(value = "/editBattle")
    public String populateBattleList(Model model) {

        List<Battle> battles = battleService.getBattles();
        model.addAttribute("battles", battles);
        model.addAttribute("name", null);
        model.addAttribute("code", null);
        return "battle-editor";
    }
}
