package com.gfa.orientation_exam.controllers;

import com.gfa.orientation_exam.models.Swipe;
import com.gfa.orientation_exam.models.User;
import com.gfa.orientation_exam.services.SwipeService;
import com.gfa.orientation_exam.services.UserService;
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
    private final SwipeService swipeService;

    @Autowired
    public MainController(UserService userService, SwipeService swipeService) {
        this.userService = userService;
        this.swipeService = swipeService;
    }

    @GetMapping("/")
    public String showRegister(Model model,
                               @ModelAttribute User user,
                               @RequestParam(required = false) String message) {
        model.addAttribute("user", user);
        model.addAttribute("message", message);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(RedirectAttributes redirectAttributes,
                               @ModelAttribute User user) {
        if (userService.isUsernameAvailable(user.getUsername())) {
            userService.saveNewUser(user);
            return "redirect:/profile/?userId=" + user.getId();
        } else {
            redirectAttributes.addFlashAttribute(user);
            redirectAttributes.addAttribute("message",
                    "Username is not available!");
            return "redirect:/";
        }
    }

    @GetMapping("/profile")
    public String showProfile(Model model,
                              @RequestParam(required = false) Long userId) {
        if (userId == null) {
            return "redirect:/";
        } else {
            User currentUser = userService.getUserById(userId);
            if (currentUser == null) {
                return "redirect:/";
            } else {
                User randomUser = userService.getRandomUser();
                model.addAttribute("currentUser", currentUser);
                model.addAttribute("randomUser", randomUser);
                return "profile";
            }
        }
    }

    @PostMapping("/swipe")
    public String swipe(@ModelAttribute Swipe newSwipe) {
        Swipe existingSwipe = swipeService.getSwipeByCurrentUserIdAndRandomUserId(newSwipe.getCurrentUserId(), newSwipe.getRandomUserId());
        if (existingSwipe == null) {
            swipeService.saveNewSwipe(newSwipe);
        } else {
            swipeService.updateSwipeDirection(existingSwipe, newSwipe.getSwipeDirection());
        }
        return "redirect:/profile/?userId=" + newSwipe.getCurrentUserId();
    }
}
