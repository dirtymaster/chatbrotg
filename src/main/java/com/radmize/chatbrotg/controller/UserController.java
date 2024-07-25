package com.radmize.chatbrotg.controller;

import com.radmize.chatbrotg.dto.AuthRequest;
import com.radmize.chatbrotg.entity.User;
import com.radmize.chatbrotg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/auth")
    public ResponseEntity<User> signUpOrIn(@RequestBody AuthRequest request) {
        return ResponseEntity.ok().body(userService.signUpOrgLogin(request));
    }
}
