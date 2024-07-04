package com.radmize.chatbrotg.service;

import com.radmize.chatbrotg.dto.LoginRequest;
import com.radmize.chatbrotg.entity.User;
import com.radmize.chatbrotg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User login(LoginRequest request) {
        return userRepository.getByEmailAndPasswordHash(request.getEmail(), request.getPasswordHash());
    }
}
