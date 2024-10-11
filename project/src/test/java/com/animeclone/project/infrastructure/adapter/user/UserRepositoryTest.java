package com.animeclone.project.infrastructure.adapter.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("docker")
class UserRepositoryTest {

    
    @Autowired
    UserRepository userRepository;
    @Test
    void findByEmail() {
       Optional<UserEntity> user= userRepository.findByEmail("user@gmail.com");
        System.out.println("userRepository = " + user.get().getEmail());
    }
}