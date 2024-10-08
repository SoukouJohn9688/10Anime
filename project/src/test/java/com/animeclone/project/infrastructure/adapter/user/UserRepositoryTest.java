package com.animeclone.project.infrastructure.adapter.user;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ActiveProfiles.class)
@ActiveProfiles(value = "docker")
class UserRepositoryTest {

//    public UserRepositoryTest(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Inject
    private UserRepository userRepository;


    @Test
    void findByEmail() {
        userRepository.findByEmail("user@gmail.com");
        System.out.println("hola");
    }
}