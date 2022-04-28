package com.gfa.p2p_chat.controllers;

import com.gfa.p2p_chat.models.User;
import com.gfa.p2p_chat.services.UserService;
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
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showIndex(@RequestParam(required = false) String username) {
        if (username == null || username.trim().isEmpty()) {
            return "redirect:/register";
        } else {
            return "index";
        }
    }

    @GetMapping("/register")
    public String showRegister(@ModelAttribute User user,
                               @RequestParam(required = false) String message,
                               Model model) {
        model.addAttribute("message", message);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user,
                           RedirectAttributes redirectAttributes) {
        String username = user.getUsername();
        if (username == null || username.trim().isEmpty()) {
            redirectAttributes.addAttribute("message", "The username field is empty.");
            return "redirect:/register";
        } else if (userService.userExists(username)) {
            redirectAttributes.addAttribute("message", "Username is already taken.");
            redirectAttributes.addFlashAttribute(user);
            return "redirect:/register";
        } else {
            userService.saveNewUser(user);
            return "redirect:/?username=" + username;
        }
    }
}
