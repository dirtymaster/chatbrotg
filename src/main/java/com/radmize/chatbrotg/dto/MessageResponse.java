package com.radmize.chatbrotg.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
public class MessageResponse {
    private UUID id;
    private UserResponse author;
    private Instant createdAt;
}
