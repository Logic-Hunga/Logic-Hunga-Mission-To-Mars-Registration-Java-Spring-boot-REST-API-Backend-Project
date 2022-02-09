/**CONFIGURATION FILE*/
package com.example.Mission.To.Mars.Registration.Client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository) { // (Injecting repository, Having access to repository
        return args -> {

            // Client
            Client SPACEX = new Client(
                    'f',
                    "Aine",
                    LocalDate.of(1994, Month.APRIL, 4),
                    "m13@gmail.com",
                    "233uuurhh",
                    "MUBAS",
                    "Mozambique"
            );

            repository.saveAll(
                    List.of(SPACEX)
            );
        };
    }
}
