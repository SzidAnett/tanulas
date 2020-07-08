package com.dispring.dispring.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("sum: " + (Integer.parseInt(args[0]) + Integer.parseInt(args[1])));
    }
}
