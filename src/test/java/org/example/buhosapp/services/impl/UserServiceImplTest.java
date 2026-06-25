package org.example.buhosapp.services.impl;

import org.example.buhosapp.common.mappers.UserMapper;
import org.example.buhosapp.domain.dtos.request.CreateUserRequest;
import org.example.buhosapp.domain.dtos.response.UserResponse;
import org.example.buhosapp.domain.entities.User;
import org.example.buhosapp.exceptions.ResourceNotFoundException;
import org.example.buhosapp.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private UUID userId;
    private CreateUserRequest request;
    private User userEntity;
    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();

        request = CreateUserRequest.builder()
                .username("paco")
                .email("paco@test.com")
                .card("00000000")
                .password("123456abc")
                .build();

        userEntity = User.builder()
                .id(userId)
                .username(request.getUsername())
                .email(request.getEmail())
                .card(request.getCard())
                .password(request.getPassword())
                .build();

        userResponse = UserResponse.builder()
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .card(userEntity.getCard())
                .build();
    }

    @Test
    void createUser_shouldSaveAndReturnUser() {
        when(userMapper.toEntity(request)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userMapper.toDto(userEntity)).thenReturn(userResponse);

        UserResponse result = userService.createUser(request);

        assertThat(result).isEqualTo(userResponse);
    }

    @Test
    void getUserById_shouldReturnUser_whenUserExists() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));
        when(userMapper.toDto(userEntity)).thenReturn(userResponse);

        UserResponse result = userService.getUserById(userId);

        assertThat(result).isEqualTo(userResponse);
    }

    @Test
    void getUserById_shouldThrowException_whenUserNotFound() {
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.getUserById(userId))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("User not found");
    }
}
