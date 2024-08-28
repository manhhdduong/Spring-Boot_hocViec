package com.dev.springbootKNDB.dto.response;

import com.dev.springbootKNDB.entity.Permission;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleReponse {
    String name;
    String description;
    Set<PermissionResponse> permissions;
}
