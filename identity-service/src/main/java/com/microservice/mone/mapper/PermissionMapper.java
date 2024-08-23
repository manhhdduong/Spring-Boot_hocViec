package com.microservice.mone.mapper;

import com.microservice.mone.dto.request.PermissionRequest;
import com.microservice.mone.dto.response.PermissionResponse;
import com.microservice.mone.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
