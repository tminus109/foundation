package com.gfa.orientation_exam.services;

import com.gfa.orientation_exam.models.User;
import com.gfa.orientation_exam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUsernameAvailable(String username) {
        User user = userRepository.findByUsernameIgnoreCase(username);
        return user == null;
    }

    public void saveNewUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getRandomUser() {
        List<User> users = (List<User>) userRepository.findAll();
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }
}
