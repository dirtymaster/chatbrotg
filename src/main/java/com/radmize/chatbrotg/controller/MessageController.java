package com.radmize.chatbrotg.controller;

import com.radmize.chatbrotg.dto.NewMessageRequest;
import com.radmize.chatbrotg.entity.Message;
import com.radmize.chatbrotg.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllSorted());
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody NewMessageRequest request) {
        messageService.save(request);
        return ResponseEntity.ok().build();
    }
}
