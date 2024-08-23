package com.microservice.mone.mapper;

import com.microservice.mone.dto.request.UserCreationRequest;
import com.microservice.mone.dto.request.UserUpdateRequest;
import com.microservice.mone.dto.response.UserResponse;
import com.microservice.mone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
