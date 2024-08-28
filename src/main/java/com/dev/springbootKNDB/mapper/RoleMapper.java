package com.dev.springbootKNDB.mapper;

import com.dev.springbootKNDB.dto.request.RoleRequest;
import com.dev.springbootKNDB.dto.response.RoleReponse;
import com.dev.springbootKNDB.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleReponse toRoleReponse(Role role);
}
