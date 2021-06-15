package com.example.studentsLog.repository;

import com.example.studentsLog.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    public UserEntity findByOtp(String otp);
}
