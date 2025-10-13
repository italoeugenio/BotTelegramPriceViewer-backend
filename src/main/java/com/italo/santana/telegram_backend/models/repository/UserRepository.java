package com.italo.santana.telegram_backend.models.repository;

import com.italo.santana.telegram_backend.models.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    UserDetails findByEmail(String email);

    @Query('select u.email from tb_users u limit 1')



}
