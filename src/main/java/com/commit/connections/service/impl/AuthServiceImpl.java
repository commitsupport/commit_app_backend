package com.commit.connections.service.impl;

import com.commit.connections.dto.auth.LoginRequest;
import com.commit.connections.dto.auth.LoginResponse;
import com.commit.connections.entity.User;
import com.commit.connections.entity.UserSession;
import com.commit.connections.exception.InvalidCredentials;
import com.commit.connections.exception.UserNotFoundException;
import com.commit.connections.repository.UserRepository;
import com.commit.connections.repository.UserSessionRepository;
import com.commit.connections.security.PasswordHasher;
import com.commit.connections.security.TokenSession;
import com.commit.connections.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private UserSessionRepository userSessionRepository;

    public AuthServiceImpl(UserRepository userRepository, UserSessionRepository userSessionRepository) {
        this.userRepository = userRepository;
        this.userSessionRepository = userSessionRepository;
    }

    @Override
    @Transactional
    public LoginResponse login(LoginRequest loginRequest) {

        // wyszukanie usera po login + status
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByLoginAndStatus(loginRequest.getLogin(), "A")
                .orElseThrow(() -> new UserNotFoundException("Login not found: " + loginRequest.getLogin())));

        // Sprawdzenie hasła w bazie
        PasswordHasher passwordHasher = new PasswordHasher();
        boolean correctPassword = passwordHasher
                .checkPassword(loginRequest.getPassword(),userOptional.get().getPassword());
        if (!correctPassword) {
            throw new InvalidCredentials(
                    "Podane login lub hasło jest nieprawidłowe",
                    "Login: " + loginRequest.getLogin()
            );
        }

        // Wygenerowanie tokena
        String token = TokenSession.generateToken();
        String hashToken = TokenSession.hashToken(token);

        // usunięcie poprzednich sesji użytkownika
        userSessionRepository.setStatusInactiveByUserid(userOptional.get().getGid());

        // Zapisanie w bazie noewej sesji użytkownika
        UserSession userSession = new UserSession();
        userSession.setUsrid(userOptional.get().getGid());
        userSession.setToken(hashToken);
        userSession.setStatus("A");
        userSession.setUpdusrid(userOptional.get().getGid());
        userSession.setInsusrid(userOptional.get().getGid());
        userSessionRepository.save(userSession);

        // budowanie response
        LoginResponse loginResponse = new LoginResponse(
                userOptional.get().getGid(),
                token,
                userOptional.get().getLogin(),
                userOptional.get().getName()
        );

        return loginResponse;
    }
}
