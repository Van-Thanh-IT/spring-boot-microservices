package com.example.user_service.service;

import com.example.user_service.dto.requestDTO.CreateUserRequest;
import com.example.user_service.dto.resposeDTO.UserResponse;
import com.example.user_service.entity.User;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository,
                       UserMapper mapper,
                       PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse create(CreateUserRequest request) {

        if (repository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = mapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User saved = repository.save(user);

        return mapper.toResponse(saved);
    }
}
