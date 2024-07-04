package com.radmize.chatbrotg.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserResponse {
    private UUID id;
    private String name;
}
