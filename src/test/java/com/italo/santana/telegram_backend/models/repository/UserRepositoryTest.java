package com.italo.santana.telegram_backend.models.repository;

import com.italo.santana.telegram_backend.enums.UserRole;
import com.italo.santana.telegram_backend.models.dtos.RegisterDTO;
import com.italo.santana.telegram_backend.models.entities.UserModel;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should return true, if exist a user in database")
    void existsAnyUserSuccess() {
        RegisterDTO data = new RegisterDTO("Ítalo Santana", "italoeugenio539@gmail.com", "12345", UserRole.OWNER);
        this.createUser(data);
    }

    private UserModel createUser(RegisterDTO data){
        UserModel newUser = new UserModel(data);
        this.entityManager.persist(newUser);
        return newUser;
    }
}