package com.dev.springbootKNDB.controller;

import com.dev.springbootKNDB.dto.response.ApiResponse;
import com.dev.springbootKNDB.dto.request.UserCreationRequest;
import com.dev.springbootKNDB.dto.request.UserUpdateRequest;
import com.dev.springbootKNDB.dto.response.UserResponse;
import com.dev.springbootKNDB.entity.User;
import com.dev.springbootKNDB.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @GetMapping
    public List<User> getU(){
        return userService.getU();
    }

    @PostMapping
    public ApiResponse<User> createU(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createU(request));
        return apiResponse;
    }

    @GetMapping("/{id}")
    public UserResponse oneU(@PathVariable String id){
        return userService.oneU(id);
    }

    @DeleteMapping("/{id}")
    public String deleteU(@PathVariable String id){
        userService.deleteU(id);
        return "deleted";
    }

    @PutMapping("/{id}")
    public UserResponse updateU(@PathVariable String id, @RequestBody UserUpdateRequest request){
        return userService.updateU(id,request);
    }
}
