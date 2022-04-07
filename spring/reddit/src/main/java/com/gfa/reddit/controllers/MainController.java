package com.gfa.reddit.controllers;

import com.gfa.reddit.models.User;
import com.gfa.reddit.services.PostService;
import com.gfa.reddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reddit")
public class MainController {
    private final UserService userService;
    private final PostService postService;
    private long loggedUserId;

    @Autowired
    public MainController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
        this.loggedUserId = 0;
    }

    @GetMapping("/")
    public String showPosts(Model model) {
        return viewPages(model, 1);
    }

    @RequestMapping("/page/{pageNumber}")
    public String viewPages(Model model,
                            @PathVariable int pageNumber) {
        if (loggedUserId == 0) {
            return "redirect:/reddit/login";
        } else {
            model.addAttribute("currentPage", pageNumber);
            model.addAttribute("totalPages", postService.listAll(pageNumber).getTotalPages());
            model.addAttribute("posts", postService.listAll(pageNumber).getContent());
            model.addAttribute("loggedUser", userService.getUserById(loggedUserId));
            return "posts";
        }
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addNewUser(@ModelAttribute User user,
                             Model model) {
        if (userService.isUsernameAvailable(user.getUsername())) {
            userService.addNewUser(user);
            return "redirect:/reddit/login";
        } else {
            model.addAttribute("message", "Username is not available!");
            return "register";
        }
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedUserId = user.getId();
            return "redirect:/reddit/";
        } else {
            model.addAttribute("message", "Username or password is not correct!");
            return "login";
        }
    }

    @GetMapping("/add_post")
    public String showAddPost() {
        return "add_post";
    }

    @PostMapping("/add_post")
    public String addNewPost(@RequestParam String title,
                             @RequestParam String url) {
        User user = userService.getUserById(loggedUserId);
        postService.saveNewPost(title, url, user);
        return "redirect:/reddit/";
    }

    @GetMapping("/like/{id}")
    public String likePost(@PathVariable long id) {
        userService.upvotePost(id, loggedUserId);
        return "redirect:/reddit/";
    }

    @GetMapping("/dislike/{id}")
    public String dislikePost(@PathVariable long id) {
        userService.downvotePost(id, loggedUserId);
        return "redirect:/reddit/";
    }
}
