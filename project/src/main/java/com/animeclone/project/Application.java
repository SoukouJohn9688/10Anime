package com.animeclone.project;

import com.animeclone.project.infrastructure.adapter.role.RoleEnum;
import com.animeclone.project.infrastructure.adapter.user.UserEntity;
import com.animeclone.project.infrastructure.adapter.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableAsync
@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.animeclone.project.infrastructure.adapter.user")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        return args -> {
//            var user = UserEntity.builder()
//                    .email("baphomet666@gmail.com")
//                    .roles(RoleEnum.ADMIN)
//                    .password("415645662Asd34")
//                    .username("diablitosdf69")
//                    .build();
//            userRepository.save(user);
//        };
//    }


}
