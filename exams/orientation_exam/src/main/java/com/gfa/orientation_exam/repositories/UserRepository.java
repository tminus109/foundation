package com.gfa.orientation_exam.repositories;

import com.gfa.orientation_exam.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsernameIgnoreCase(String username);
}
