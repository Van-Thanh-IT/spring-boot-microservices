package com.example.user_service.mapper;

import com.example.user_service.dto.requestDTO.CreateUserRequest;
import com.example.user_service.dto.resposeDTO.UserResponse;
import com.example.user_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // Request → Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "status", constant = "ACTIVE")
    User toEntity(CreateUserRequest request);

    // Entity → Response
    UserResponse toResponse(User user);
}
