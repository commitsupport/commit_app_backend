package com.commit.connections.repository;

import com.commit.connections.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLoginAndStatus(String login, String status);
}
