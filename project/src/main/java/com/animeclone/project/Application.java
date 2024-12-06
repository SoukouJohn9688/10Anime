package com.animeclone.project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;



@EnableAsync
@SpringBootApplication
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
