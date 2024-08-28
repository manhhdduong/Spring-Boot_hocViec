package com.dev.springbootKNDB.controller;

import com.dev.springbootKNDB.dto.response.ApiResponse;
import com.dev.springbootKNDB.dto.request.UserCreationRequest;
import com.dev.springbootKNDB.dto.request.UserUpdateRequest;
import com.dev.springbootKNDB.dto.response.UserResponse;
import com.dev.springbootKNDB.entity.User;
import com.dev.springbootKNDB.repository.UserRepository;
import com.dev.springbootKNDB.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {

    UserService userService;

    UserRepository userRepository;
    @GetMapping
    ApiResponse<List<UserResponse>> getU(){
        var authencation = SecurityContextHolder.getContext().getAuthentication();
        List<User> users =new ArrayList<>();

        log.info("Username: {}",authencation.getName());
        authencation.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getU())
                .build();
    }


    @PostMapping
    ApiResponse<UserResponse> createU(@RequestBody @Valid UserCreationRequest request){

        return ApiResponse.<UserResponse>builder()
                .result(userService.createU(request))
                .build();
    }

    @GetMapping("/myInfo")
    ApiResponse<UserResponse> getMyInfo() {

        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @DeleteMapping("/{id}")
    public void deleteU(@PathVariable String id){
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateU(@PathVariable String id, @RequestBody UserUpdateRequest request){
        return userService.updateU(id,request);
    }
}
