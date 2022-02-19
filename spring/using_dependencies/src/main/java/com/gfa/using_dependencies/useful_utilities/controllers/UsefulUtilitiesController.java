package com.gfa.using_dependencies.useful_utilities.controllers;

import com.gfa.using_dependencies.useful_utilities.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsefulUtilitiesController {
    UtilityService utilityService;

    @Autowired
    public UsefulUtilitiesController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @GetMapping("/useful")
    public String showIndex() {
        return "useful_utilities/index";
    }

    @GetMapping("/useful/colored")
    public String showColoredBackground(Model model) {
        model.addAttribute("color", utilityService.randomColor());
        return "useful_utilities/colored_background";
    }

    @GetMapping("/useful/email")
    public String showEmailValidator() {
        return "useful_utilities/email_validator";
    }

    @PostMapping("/useful/email")
    public String validateEmail(@RequestParam String email, Model model) {
        if (email.contains("@") && email.contains(".")) {
            model.addAttribute("result",
                    email + " is a valid email address");
            model.addAttribute("color", "green");
        } else {
            model.addAttribute("result",
                    email + " is not a valid email address");
            model.addAttribute("color", "red");
        }
        return "useful_utilities/email_validator";
    }

    @GetMapping("/useful/caesar/encode")
    public String showCaesarEncode() {
        return "useful_utilities/caesar_encode";
    }

    @PostMapping("/useful/caesar/encode")
    public String caesarEncode(@RequestParam String text, @RequestParam int number, Model model) {
        model.addAttribute("code", utilityService.caesar(text, number));
        return "useful_utilities/caesar_encode";
    }

    @GetMapping("/useful/caesar/decode")
    public String showCaesarDecode() {
        return "useful_utilities/caesar_decode";
    }

    @PostMapping("/useful/caesar/decode")
    public String caesarDecode(@RequestParam String text, @RequestParam int number, Model model) {
        model.addAttribute("code", utilityService.caesar(text, -number));
        return "useful_utilities/caesar_decode";
    }
}
