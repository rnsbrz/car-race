package com.spring.porscheRace.service;

import com.spring.porscheRace.model.User;

public interface UserService {
    void createUser(User user);
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}
