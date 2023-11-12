package com.example.footballers.auth.services;

import com.example.footballers.auth.entities.User;
import com.example.footballers.auth.entities.Role;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = List.of(
                new User("mainCoach", "1234", "Сергей", "Семак", Collections.singleton(Role.USER)),
                new User("revCoach", "1234", "Анатолий", "Тимощук", Collections.singleton(Role.USER)),
                new User("admin", "12345", "admin", "admin", Collections.singleton(Role.ADMIN))
        );
    }

    public Optional<User> getByLogin(@NonNull String login) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }

}
