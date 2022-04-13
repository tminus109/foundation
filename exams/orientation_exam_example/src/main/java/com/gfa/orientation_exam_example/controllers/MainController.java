package com.gfa.orientation_exam_example.controllers;

import com.gfa.orientation_exam_example.models.UrlAlias;
import com.gfa.orientation_exam_example.models.SecretCode;
import com.gfa.orientation_exam_example.services.UrlAliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
    private final UrlAliasService urlAliasService;

    @Autowired
    public MainController(UrlAliasService urlAliasService) {
        this.urlAliasService = urlAliasService;
    }

    @GetMapping("/")
    public String showIndex(Model model,
                            @ModelAttribute UrlAlias urlAlias,
                            @RequestParam(required = false) String message) {
        model.addAttribute("urlAlias", urlAlias);
        model.addAttribute("message", message);
        return "index";
    }

    @PostMapping("/save_link")
    public String saveNewUrlAlias(RedirectAttributes redirectAttributes,
                                  @ModelAttribute UrlAlias urlAlias) {
        if (urlAliasService.isAliasInUse(urlAlias.getAlias())) {
            redirectAttributes.addFlashAttribute(urlAlias);
            redirectAttributes.addAttribute("message",
                    "Your alias is already in use!");
        } else {
            urlAliasService.saveNewUrlAlias(urlAlias, new SecretCode());
            redirectAttributes.addAttribute("message",
                    "Your URL is aliased to " + urlAlias.getAlias() +
                            " and your secret code is " + urlAlias.getSecretCode() + ".");
        }
        return "redirect:/";
    }
}
