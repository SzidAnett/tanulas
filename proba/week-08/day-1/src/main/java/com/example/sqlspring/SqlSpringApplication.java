package com.example.sqlspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SqlSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlSpringApplication.class, args);
    }
    @Bean
    public CommandLineRunner catDatabase(CatRepository catRepository) {
        return (args) -> {

            //save a cat
            catRepository.save(new Cat("micike"));
            catRepository.save(new Cat("Cirmoska"));

            //get all the names
            for (Cat cat : catRepository.findAll()) {
                System.out.println(cat.getName());
            }

            //get cat by id

            Cat cat = catRepository.findCatById(1L).get(0);
            System.out.println(cat.getName());

            // update name of the cat

            Cat catToUpdate = catRepository.findById(1L).get();
            catToUpdate.setName("Borond Odon");
            catRepository.save(catToUpdate);

            for (Cat cats : catRepository.findAll()) {
                System.out.println(cats.getName());
            }

            catRepository.deleteAll();

            for (Cat cats : catRepository.findAll()) {
                System.out.println(cats.getName());
            }

        };
    }
}

