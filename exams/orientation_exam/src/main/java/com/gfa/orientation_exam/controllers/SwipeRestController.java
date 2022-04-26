package com.gfa.orientation_exam.controllers;

import com.gfa.orientation_exam.models.Swipe;
import com.gfa.orientation_exam.services.SwipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwipeRestController {
    private final SwipeService swipeService;

    @Autowired
    public SwipeRestController(SwipeService swipeService) {
        this.swipeService = swipeService;
    }

    @PutMapping("/swipe")
    public ResponseEntity<Void> modifySwipe(@RequestBody Swipe swipe) {
        Swipe existingSwipe = swipeService.getSwipeByCurrentUserIdAndRandomUserId(
                swipe.getCurrentUserId(), swipe.getRandomUserId());
        if (existingSwipe == null) {
            return ResponseEntity.status(404).build();
        }
        if (!swipe.getSwipeDirection().equals("left") &&
                !swipe.getSwipeDirection().equals("right")) {
            return ResponseEntity.status(422).build();
        }
        swipeService.updateSwipeDirection(existingSwipe, swipe.getSwipeDirection());
        return ResponseEntity.status(202).build();
    }
}
