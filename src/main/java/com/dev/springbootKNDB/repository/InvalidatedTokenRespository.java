package com.dev.springbootKNDB.repository;

import com.dev.springbootKNDB.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidatedTokenRespository extends JpaRepository<InvalidatedToken,String> {
}
