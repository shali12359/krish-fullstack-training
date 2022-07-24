package com.example.demorentprocesstask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class RentProcessTaskRunner implements CommandLineRunner {
    @Autowired
    RentProcessService rentProcessService;

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            System.out.println("With args");

            if (rentProcessService.validateDL(args[0])) {
                System.out.println("Valid License");
            }
            else {
                System.out.println("Invalid License");
            }
        }
        else {
            System.out.println("Without args");
        }
    }
}
