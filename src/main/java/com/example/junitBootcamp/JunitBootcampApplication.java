package com.example.junitBootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.junitBootcamp.servicios.CalculadoraImpl;

@SpringBootApplication
public class JunitBootcampApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JunitBootcampApplication.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
