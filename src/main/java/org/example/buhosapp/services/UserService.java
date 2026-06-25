package org.example.buhosapp.services;

import org.example.buhosapp.domain.dtos.request.CreateUserRequest;
import org.example.buhosapp.domain.dtos.response.UserResponse;
import java.util.UUID;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    UserResponse getUserById(UUID id);
}
