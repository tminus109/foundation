package com.gfa.p2p_chat.repositories;

import com.gfa.p2p_chat.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsernameIgnoreCase(String username);
}
