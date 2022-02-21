package com.gfa.fox_club.controllers;

import com.gfa.fox_club.models.*;
import com.gfa.fox_club.services.FoxService;
import com.gfa.fox_club.services.NutritionStore;
import com.gfa.fox_club.services.TrickCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class MainController {
    private final FoxService foxService;
    private final NutritionStore nutritionStore;
    private final TrickCenter trickCenter;

    @Autowired
    public MainController(FoxService foxService, NutritionStore nutritionStore, TrickCenter trickCenter) {
        this.foxService = foxService;
        this.nutritionStore = nutritionStore;
        this.trickCenter = trickCenter;
    }

    @GetMapping("/")
    public String showIndex(@RequestParam(required = false) String name, Model model) {
        if (name == null || name.isEmpty()) {
            return "redirect:/login";
        } else {
            model.addAttribute("fox", foxService.getFoxByName(name));
            return "index";
        }
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String name) {
        if (foxService.getFoxByName(name) == null) {
            Fox fox = new Fox(name);
            foxService.addNewFox(fox);
            fox.addNewAction(new Action(" - New pet created, named " + name + "."));
            fox.addNewAction(new Action(" - " + name + " logged in."));
        } else {
            Fox fox = foxService.getFoxByName(name);
            fox.addNewAction(new Action(" - " + name + " logged in."));
        }
        return "redirect:/?name=" + name;
    }

    @GetMapping("/nutrition_store")
    public String showNutritionStore(@RequestParam(required = false) String name,
                                     Model model) {
        if (name == null || name.isEmpty()) {
            return "redirect:/login";
        } else {
            model.addAttribute("fox", foxService.getFoxByName(name));
            model.addAttribute("store", nutritionStore);
        }
        return "nutrition_store";
    }

    @PostMapping("/nutrition_store")
    public String updateNutrition(@RequestParam() String name,
                                  @RequestParam() Food food,
                                  @RequestParam() Drink drink,
                                  Model model) {
        Fox fox = foxService.getFoxByName(name);
        if (!Objects.equals(fox.getFood().getName(), food.getName())) {
            fox.setFood(food);
            fox.addNewAction(new Action(" - " + name + " is living on " + food.getName() + "."));
        }
        if (!Objects.equals(fox.getDrink().getName(), drink.getName())) {
            fox.setDrink(drink);
            fox.addNewAction(new Action(" - " + name + " is living on " + drink.getName() + "."));
        }
        return "redirect:/?name=" + name;
    }

    @GetMapping("/trick_center")
    public String showTrickCenter(@RequestParam(required = false) String name,
                                  Model model) {
        if (name == null || name.isEmpty()) {
            return "redirect:/login";
        } else {
            Fox fox = foxService.getFoxByName(name);
            model.addAttribute("fox", fox);
            model.addAttribute("tricks", trickCenter.getAvailableTricks(fox));
            return "trick_center";
        }
    }

    @PostMapping("/trick_center")
    public String learnNewTrick(@RequestParam() String name,
                                @RequestParam Trick trick) {
        Fox fox = foxService.getFoxByName(name);
        fox.learnNewTrick(trick);
        fox.addNewAction(new Action(" - " + name + " learnt to " + trick.getName() + "."));
        return "redirect:/?name=" + name;
    }

    @GetMapping("/action_history")
    public String showActionHistory(@RequestParam(required = false) String name,
                                    Model model) {
        if (name == null || name.isEmpty()) {
            return "redirect:/login";
        } else {
            Fox fox = foxService.getFoxByName(name);
            model.addAttribute("fox", fox);
            return "action_history";
        }
    }
}
