package baza.slodycz;

import baza.slodycz.api.domain.Slodycz;
import baza.slodycz.api.services.SlodyczManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class SlodyczeApp {
    public static void main(String[] args){
        SpringApplication.run(SlodyczeApp.class, args);
    }
}
