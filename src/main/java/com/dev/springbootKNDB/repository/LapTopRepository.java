package com.dev.springbootKNDB.repository;

import com.dev.springbootKNDB.entity.LapTop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LapTopRepository extends JpaRepository<LapTop,String> {
    boolean existsByImei(String imei);
}
