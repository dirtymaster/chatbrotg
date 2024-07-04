package com.radmize.chatbrotg.repository;

import com.radmize.chatbrotg.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User getByEmailAndPasswordHash(String email, String passwordHash);
}
