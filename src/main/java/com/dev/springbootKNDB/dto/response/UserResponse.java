package com.dev.springbootKNDB.dto.response;

import com.dev.springbootKNDB.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;

    String username;

    String firstname;

    String lastname;

    LocalDate dob;

    Set<Role> roles;
}
