package org.example.buhosapp.common.mappers;

import org.example.buhosapp.domain.dtos.request.CreateUserRequest;
import org.example.buhosapp.domain.dtos.response.UserResponse;
import org.example.buhosapp.domain.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(CreateUserRequest request) {
        if (request == null) {
            return null;
        }
        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .card(request.getCard())
                .password(request.getPassword())
                .build();
    }

    public UserResponse toDto(User user) {
        if (user == null) {
            return null;
        }
        return UserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .card(user.getCard())
                .build();
    }
}
