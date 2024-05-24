package com.spring.porscheRace.controller;

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

import java.text.DecimalFormat;
import java.util.HashMap;
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
    String result(@Valid @ModelAttribute("race") Race race, BindingResult br,
                  @RequestParam HashMap<String, String> cars, ModelMap modelMap){

        if (br.hasErrors()){
            return "raceSelector";
        } else {
            String car1 = cars.get("car1");
            String car2 = cars.get("car2");
            int car1Hp = Integer.parseInt(cars.get("car1Hp"));
            int car2Hp = Integer.parseInt(cars.get("car2Hp"));

            String result;

            Random random = new Random();

            double totalHp = car1Hp + car2Hp;
            double odds1 = car1Hp/totalHp;
            double odds2 = 1-odds1;
            double randomValue = random.nextDouble();

            result = randomValue < odds1 ? car1 + " wins!" : car2 + " wins!";

            modelMap.put("car1Hp", car1Hp);
            modelMap.put("car2Hp", car2Hp);
            modelMap.put("car1", car1);
            modelMap.put("car2", car2);
            modelMap.put("result", result);

            raceService.save(new Race(car1, car2, car1Hp, car2Hp, result));

            return "result";
        }
    }

    @GetMapping(value = "/allRaces")
    public String allRaces(Model model) {
        model.addAttribute("races", raceService.getAll());
        return "allRaces";
    }

    @GetMapping(value = "/showRace")
    public String showRace(int id, Model model) {
        System.out.println(id);
        model.addAttribute("race", raceService.getById(id));
        System.out.println(raceService.getById(id));
        return "race";
    }

    @GetMapping(value = "/delete")
    public String delete(int id, Model model) {
        raceService.delete(id);
        model.addAttribute("race", raceService.getAll());
        return "redirect:/allRaces";
    }

    @GetMapping(value = "/updateRace")
    public String update(int id, Model model) {
        model.addAttribute("race", raceService.getById(id));
        return "updateRace";
    }

    @PostMapping(value = "/updateR")
    public String updateNum(@ModelAttribute("race") Race race) {
        raceService.update(race);
        return "redirect:/showNum?id=" + race.getId();
    }

}
