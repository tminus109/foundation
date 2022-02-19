package com.gfa.using_dependencies;

import com.gfa.using_dependencies.playing_with_colors.services.BlackColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplication implements CommandLineRunner {
    private final BlackColor blackColor;

    @Autowired
    public SpringApplication(BlackColor blackColor) {
        this.blackColor = blackColor;
    }

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        blackColor.printColor();
    }
}
