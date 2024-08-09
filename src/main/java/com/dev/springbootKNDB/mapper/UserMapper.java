package com.dev.springbootKNDB.mapper;

import com.dev.springbootKNDB.dto.request.UserCreationRequest;
import com.dev.springbootKNDB.dto.request.UserUpdateRequest;
import com.dev.springbootKNDB.dto.response.UserResponse;
import com.dev.springbootKNDB.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toU(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateU(@MappingTarget User user, UserUpdateRequest request);
}
