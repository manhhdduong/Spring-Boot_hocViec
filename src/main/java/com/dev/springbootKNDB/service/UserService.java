package com.dev.springbootKNDB.service;

import com.dev.springbootKNDB.dto.request.UserCreationRequest;
import com.dev.springbootKNDB.dto.request.UserUpdateRequest;
import com.dev.springbootKNDB.dto.response.UserResponse;
import com.dev.springbootKNDB.entity.User;
import com.dev.springbootKNDB.enums.Role;
import com.dev.springbootKNDB.exception.AppException;
import com.dev.springbootKNDB.exception.ErrorCode;
import com.dev.springbootKNDB.mapper.UserMapper;
import com.dev.springbootKNDB.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {

        UserRepository userRepository;

        UserMapper userMapper;

        PasswordEncoder passwordEncoder;

    public UserResponse createU(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toU(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
//        user.setRoles(roles);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse getMyInfo(){
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getU(){
        log.info("In method get Users");
        return userRepository.findAll().stream().
                map(userMapper::toUserResponse).toList();
    }

    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse oneU(String id){
        log.info("In method get user by id");
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_EXISTED)));
    }

    public void deleteU(String id){
        userRepository.deleteById(id);
    }

    public UserResponse updateU(String id, UserUpdateRequest request){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not Found!"));

        userMapper.updateU(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

}
