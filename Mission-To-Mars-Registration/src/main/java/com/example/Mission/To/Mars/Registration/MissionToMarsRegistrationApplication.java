package com.example.Mission.To.Mars.Registration;

import com.example.Mission.To.Mars.Registration.Client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication

public class MissionToMarsRegistrationApplication {


	public static void main(String[] args) {
		SpringApplication.run(MissionToMarsRegistrationApplication.class, args);
	}
}

