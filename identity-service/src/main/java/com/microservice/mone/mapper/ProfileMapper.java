package com.microservice.mone.mapper;

import com.microservice.mone.dto.request.ProfileCreationRequest;
import com.microservice.mone.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
