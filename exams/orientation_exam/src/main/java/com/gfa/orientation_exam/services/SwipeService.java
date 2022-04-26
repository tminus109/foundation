package com.gfa.orientation_exam.services;

import com.gfa.orientation_exam.models.Swipe;
import com.gfa.orientation_exam.repositories.SwipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwipeService {
    private final SwipeRepository swipeRepository;

    @Autowired
    public SwipeService(SwipeRepository swipeRepository) {
        this.swipeRepository = swipeRepository;
    }

    public void saveNewSwipe(Swipe swipe) {
        swipeRepository.save(swipe);
    }

    public Swipe getSwipeByCurrentUserIdAndRandomUserId(Long currentUserId, Long otherUserId) {
        return swipeRepository.findByCurrentUserIdAndRandomUserId(currentUserId, otherUserId);
    }

    public void updateSwipeDirection(Swipe swipe, String swipeDirection) {
        swipe.setSwipeDirection(swipeDirection);
        swipeRepository.save(swipe);
    }
}
