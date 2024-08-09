package com.dev.springbootKNDB.service;

import com.dev.springbootKNDB.dto.request.UserCreationRequest;
import com.dev.springbootKNDB.dto.request.UserUpdateRequest;
import com.dev.springbootKNDB.dto.response.UserResponse;
import com.dev.springbootKNDB.entity.User;
import com.dev.springbootKNDB.exception.AppException;
import com.dev.springbootKNDB.exception.ErrorCode;
import com.dev.springbootKNDB.mapper.UserMapper;
import com.dev.springbootKNDB.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    public User createU(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toU(request);

        return userRepository.save(user);
    }

    public List<User> getU(){
        return userRepository.findAll();
    }

    public UserResponse oneU(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not Found!")));
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
