package com.imobiliaria.Desafio_Imobiliaria.profile;

import com.imobiliaria.Desafio_Imobiliaria.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("test")
public class TestProfile {
    @Autowired
    private DbService dbService;

    @Bean
    public CommandLineRunner instanciaDb() {
        return args -> {
            dbService.instanciarDb();
        };
    }
}
