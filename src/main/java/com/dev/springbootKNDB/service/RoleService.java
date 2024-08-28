package com.dev.springbootKNDB.service;

import com.dev.springbootKNDB.dto.request.RoleRequest;
import com.dev.springbootKNDB.dto.response.RoleReponse;
import com.dev.springbootKNDB.entity.Role;
import com.dev.springbootKNDB.mapper.RoleMapper;
import com.dev.springbootKNDB.repository.PermissionRepository;
import com.dev.springbootKNDB.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {

    RoleRepository roleRepository;

    RoleMapper roleMapper;

    PermissionRepository permissionRepository;

    public RoleReponse createRole(RoleRequest request){
        Role role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());

        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);

        return roleMapper.toRoleReponse(role);
    }

    public List<RoleReponse> getAll(){
        List<Role> roles = roleRepository.findAll();
        List<RoleReponse> roleResponses = new ArrayList<>();
        for (Role role : roles) {
            roleResponses.add(roleMapper.toRoleReponse(role));
        }
        return roleResponses;
    }

    public void delete(String id){
        roleRepository.deleteById(id);
    }
}
