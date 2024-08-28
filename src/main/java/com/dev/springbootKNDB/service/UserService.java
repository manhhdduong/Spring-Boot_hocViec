package com.dev.springbootKNDB.service;

import com.dev.springbootKNDB.dto.request.UserCreationRequest;
import com.dev.springbootKNDB.dto.request.UserUpdateRequest;
import com.dev.springbootKNDB.dto.response.UserResponse;
import com.dev.springbootKNDB.entity.User;
import com.dev.springbootKNDB.enums.Role;
import com.dev.springbootKNDB.exception.AppException;
import com.dev.springbootKNDB.exception.ErrorCode;
import com.dev.springbootKNDB.mapper.UserMapper;
import com.dev.springbootKNDB.repository.RoleRepository;
import com.dev.springbootKNDB.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {

        UserRepository userRepository;

        UserMapper userMapper;

        PasswordEncoder passwordEncoder;

        RoleRepository roleRepository;

    public UserResponse createU(UserCreationRequest request){

        User user = userMapper.toU(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        com.dev.springbootKNDB.entity.Role userRole = roleRepository.save(com.dev.springbootKNDB.entity.Role.builder()
                .name(com.dev.springbootKNDB.enums.Role.USER.name())
                .description("User role")
                .build());

        var roles = new HashSet<com.dev.springbootKNDB.entity.Role>();
        roles.add(userRole);

//        roleRepository.findById(Role.USER).ifPresent(roles::add);

        user.setRoles(roles);

        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return userMapper.toUserResponse(user);
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

    public UserResponse updateU(String userId, UserUpdateRequest request){
        User user = userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        userMapper.updateUser(user, request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        var roles = roleRepository.findAllById(request.getRoles());
        user.setRoles(new HashSet<>(roles));

        return userMapper.toUserResponse(userRepository.save(user));
    }

}
