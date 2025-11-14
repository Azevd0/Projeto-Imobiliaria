package com.imobiliaria.Desafio_Imobiliaria.profile;

import com.imobiliaria.Desafio_Imobiliaria.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfile {

    @Autowired
    private DbService dbService;

    @Bean
    public CommandLineRunner instanciaDb() {
        return args -> {
            dbService.instanciarDb();
        };
    }
}
