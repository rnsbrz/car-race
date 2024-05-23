package com.spring.porscheRace.controller;

import com.spring.porscheRace.model.Car;
import com.spring.porscheRace.model.Race;
import com.spring.porscheRace.service.RaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
@EnableAutoConfiguration
public class RaceController {
    private final RaceService raceService;
    @Autowired
    public RaceController(@Qualifier("RaceService") RaceService raceService){
        this.raceService = raceService;
    }

    @GetMapping("/raceSelector")
    public String raceSelector(Model model) {
        model.addAttribute("race", new Race());
        return "raceSelector";
    }

    @PostMapping("/result")
    String result(@ModelAttribute("race") Race race, Car car1, Car car2, String location, ModelMap modelMap){
        double carOdds = calculateOdds(car1.getHorsePower(), car2.getHorsePower());
        double odds = random.nextDouble();

        String result;

        if (odds < carOdds){
            result = car1.getModel()+" wins!";
        } else {
            result = car2.getModel()+" wins!";
        }

        modelMap.put("car1", car1.getModel());
        modelMap.put("car2", car2.getModel());
        modelMap.put("result", result);

        raceService.save(new Race(car1.getModel(), car2.getModel(), location, result));

        return "result";

    }
    private Random random = new Random();

    public double calculateOdds(int hp1, int hp2){
        double totalHP = hp1 + hp2;
        return hp1/totalHP;
    }
}
