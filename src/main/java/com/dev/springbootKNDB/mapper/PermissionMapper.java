package com.dev.springbootKNDB.mapper;


import com.dev.springbootKNDB.dto.request.PermissionRequest;
import com.dev.springbootKNDB.dto.response.PermissionResponse;
import com.dev.springbootKNDB.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}