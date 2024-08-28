package com.dev.springbootKNDB.controller;

import com.dev.springbootKNDB.dto.request.RoleRequest;
import com.dev.springbootKNDB.dto.response.ApiResponse;
import com.dev.springbootKNDB.dto.response.RoleReponse;
import com.dev.springbootKNDB.repository.RoleRepository;
import com.dev.springbootKNDB.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {

    RoleService roleService;

    @PostMapping
    ApiResponse<RoleReponse> creataRole(@RequestBody RoleRequest request){
        return ApiResponse.<RoleReponse>builder()
                .result(roleService.createRole(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleReponse>> getAll(){
        return ApiResponse.<List<RoleReponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("{role}")
    ApiResponse<Void> delete(@PathVariable String role){
        roleService.delete(role);
        return ApiResponse.<Void>builder().build();
    }
}
