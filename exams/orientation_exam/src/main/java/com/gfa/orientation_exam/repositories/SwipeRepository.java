package com.gfa.orientation_exam.repositories;

import com.gfa.orientation_exam.models.Swipe;
import org.springframework.data.repository.CrudRepository;

public interface SwipeRepository extends CrudRepository<Swipe, Long> {
    Swipe findByCurrentUserIdAndRandomUserId(Long currentUserId, Long otherUserId);
}
