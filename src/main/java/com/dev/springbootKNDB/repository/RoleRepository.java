package com.dev.springbootKNDB.repository;

import com.dev.springbootKNDB.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}
