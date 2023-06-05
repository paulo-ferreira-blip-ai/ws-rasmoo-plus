package com.cliente.ws.rasmooplus;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class WsRasmooPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsRasmooPlusApplication.class, args);

        // Create the Flyway instance and point it to the database
        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/RASPLUS", "rasmoo", "senha123").load();

        // Start the migration
        flyway.migrate();
    }
}