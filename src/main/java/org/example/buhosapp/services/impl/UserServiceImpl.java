package org.example.buhosapp.services.impl;

import org.example.buhosapp.common.mappers.UserMapper;
import org.example.buhosapp.domain.dtos.request.CreateUserRequest;
import org.example.buhosapp.domain.dtos.response.UserResponse;
import org.example.buhosapp.domain.entities.User;
import org.example.buhosapp.exceptions.ResourceNotFoundException;
import org.example.buhosapp.repositories.UserRepository;
import org.example.buhosapp.services.UserService;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserResponse getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.toDto(user);
    }
}
