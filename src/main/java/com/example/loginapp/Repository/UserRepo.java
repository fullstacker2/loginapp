package com.example.loginapp.Repository;

import com.example.loginapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Modifying
    @Query("SELECT 1 FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email")String email);
}
