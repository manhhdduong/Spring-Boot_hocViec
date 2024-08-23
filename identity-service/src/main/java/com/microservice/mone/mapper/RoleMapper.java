package com.microservice.mone.mapper;

import com.microservice.mone.dto.request.RoleRequest;
import com.microservice.mone.dto.response.RoleResponse;
import com.microservice.mone.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
