package com.dev.springbootKNDB.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.dev.springbootKNDB.dto.request.UserCreationRequest;
import com.dev.springbootKNDB.dto.response.UserResponse;
import com.dev.springbootKNDB.entity.User;
import com.dev.springbootKNDB.exception.AppException;
import com.dev.springbootKNDB.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
//@TestPropertySource("/test.properties")
public class UserServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Test
    void contextLoads() {
        log.info("hello chao em nha");
    }

}
