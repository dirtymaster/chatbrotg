package com.radmize.chatbrotg.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class NewMessageRequest {
    private UUID authorId;
    private String content;
}
