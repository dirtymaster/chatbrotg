package com.radmize.chatbrotg.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthRequest {
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
