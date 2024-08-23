package com.microservice.mthree.mapper;

import com.microservice.mthree.dto.request.ProfileCreationRequest;
import com.microservice.mthree.dto.response.UserProfileResponse;
import com.microservice.mthree.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
}
