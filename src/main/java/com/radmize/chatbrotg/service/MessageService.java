package com.radmize.chatbrotg.service;

import com.radmize.chatbrotg.dto.NewMessageRequest;
import com.radmize.chatbrotg.entity.Message;
import com.radmize.chatbrotg.entity.User;
import com.radmize.chatbrotg.mapper.MessageRepository;
import com.radmize.chatbrotg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public void save(NewMessageRequest request) {
        Optional<User> author = userRepository.findById(request.getAuthorId());
        author.ifPresentOrElse(user -> {
            Message message = new Message();
            message.setAuthor(user);
            message.setContent(request.getContent());
            message.setCreatedAt(Instant.now());
            messageRepository.save(message);
        }, () -> {
            throw new IllegalArgumentException("Author not found");
        });
    }

    public List<Message> getAllSorted() {
        return messageRepository.findAllByOrderByCreatedAt();
    }
}
