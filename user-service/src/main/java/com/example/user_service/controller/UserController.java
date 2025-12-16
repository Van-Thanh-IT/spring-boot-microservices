package com.example.user_service.controller;

import com.example.user_service.dto.requestDTO.CreateUserRequest;
import com.example.user_service.dto.resposeDTO.UserResponse;
import com.example.user_service.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserResponse create(@RequestBody CreateUserRequest request) {
        UserResponse user = service.create(request);

        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setUsername(user.getUsername());
        res.setEmail(user.getEmail());
        res.setFullName(user.getFullName());
        res.setPhone(user.getPhone());
        res.setRole(user.getRole());
        res.setStatus(user.getStatus());

        return res;
    }
}
