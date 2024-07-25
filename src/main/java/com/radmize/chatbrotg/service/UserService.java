package com.radmize.chatbrotg.service;

import com.radmize.chatbrotg.dto.AuthRequest;
import com.radmize.chatbrotg.entity.User;
import com.radmize.chatbrotg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User signUpOrgLogin(AuthRequest request) {
        User user = userRepository.getByEmail(request.getEmail());
        if (user == null) {
            user = new User();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPasswordHash(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
            user = userRepository.save(user);
        } else {
            if (!BCrypt.checkpw(request.getPassword(), user.getPasswordHash())) {
                throw new IllegalArgumentException("Wrong password");  // TODO: сделать нормальную обработку ошибок
            }
        }
        return user;
    }
}
