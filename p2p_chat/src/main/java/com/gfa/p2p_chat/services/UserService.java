package com.gfa.p2p_chat.services;

import com.gfa.p2p_chat.models.User;
import com.gfa.p2p_chat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveNewUser(User user) {
        userRepository.save(user);
    }

    public boolean userExists(String username) {
        User user = userRepository.findByUsernameIgnoreCase(username);
        return user != null;
    }
}
