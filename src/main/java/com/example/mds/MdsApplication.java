package com.example.mds;

import com.example.mds.entity.primary.PrimaryTodo;
import com.example.mds.entity.secondary.SecondaryTodo;
import com.example.mds.repository.primary.PrimaryTodoRepository;
import com.example.mds.repository.secondary.SecondaryTodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication(scanBasePackages = {
        "com.example.mds.repository.*"
})
@RequiredArgsConstructor
public class MdsApplication {
    private final PrimaryTodoRepository primaryRepository;
    private final SecondaryTodoRepository secondaryRepository;

    public static void main(String[] args) {
        SpringApplication.run(MdsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            var primaryTodo = new PrimaryTodo();
            primaryTodo.setTodoName("in primary");
            primaryRepository.save(primaryTodo);

            var secondaryTodo = new SecondaryTodo();
            secondaryTodo.setTodoName("in secondary");
            secondaryRepository.save(secondaryTodo);


            primaryRepository.findAll().forEach(todo -> {
                log.info("{}", todo);
            });

            secondaryRepository.findAll().forEach(todo -> {
                log.info("{}", todo);
            });
        };
    }
}
